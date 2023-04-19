#! /bin/bash
# Copyright (c) 2022 "Nicolas Cossio Miravalles"
#
# This software is released under the MIT License.
# https://opensource.org/licenses/MIT
# check if --copy_directory option is passed
# if it is, copy the scripts directory to ~/Documents/scripts
# and run the tests from there
# if it is not, run the tests from the current directory
if [ "$1" = "--nico" ]; then
    cd ~/AdminSist/ || exit
    cp -r ~/AdminSist/* ~/Documents/AdminSist/
    # run launcher again from the new directory
    cd ~/Documents/AdminSist || exit
    pwd
    ./launcher.sh
    exit
fi
selection_dialog() {
    # check if "dialog" is installed
    if ! command -v dialog &>/dev/null; then
        echo "dialog could not be found, installing..."
        sudo apt-get install dialog
    fi

    if ! command -v dialog &>/dev/null; then
        echo "mkpasswd from whois package could not be found, installing..."
        sudo apt-get install whois
    fi

    # get the files in the scripts directory and put each one in an array
    while read -r line; do
        scripts+=("$line")
    done < <(ls ./scripts)

    cmd=(dialog --title "Scripts test launcher" --no-tags
        --checklist --keep-tite "Choose which scripts to run tests for" 35 50 20)

    for opt in "${!scripts[@]}"; do
        cmd+=("$opt" "${scripts[$opt]}" on)
    done
    choices=($("${cmd[@]}" 2>&1 >/dev/tty))
    if [ $? -eq 0 ] && [ ${#choices[@]} -gt 0 ]; then
        echo "Running the following tests:"
        for sel in "${choices[@]}"; do
            # for the selected script cat the string to a file with the same name in ~/Documents/scripts and give it run permissions

            printf "\t%s\n" "${scripts[$sel]}"
            test_and_cleanup "${scripts[$sel]}"
        done
    else
        echo "No scripts selected, exiting..."
    fi
}

# Clean up functions
test_and_cleanup() {
    # test_location="./scripts/$1"
    # if [ $nico ] ; then
    #     test_location="~/Documents/scripts/crear_usuarios.sh"
    #     cat ./scripts/crear_usuarios.sh >"$test_location"
    #     sudo chmod +x "$test_location"
    # fi
    printf "Testing and cleaning up %s\n" "$1"
    case "$1" in
    "crear_usuarios.sh")
        crear_usuarios_tests
        ;;
    "configurar_almacenamiento.sh")
        configurar_almacenamiento_tests
        ;;
    "kernel_log.sh")
        kernel_log_tests
        ;;
    "nfs_cliente.sh" | "nfs_servidor.sh")
        nfs_tests
        ;;
    "maestro.sh")
        maestro_tests
        ;;
    esac
}

# testing function which is given a command to run and the expected output
# if the output is not the same as the expected output, the test fails
my_test() {
    ret_val="$?"
    if [ "$ret_val" -eq "$2" ]; then
        printf "\t%s\n" "Test passed ✅"
    else
        printf "\t%s\%s\n" "Test failed ❌ ->" " Expected: $2 : Actual: $ret_val"
        [ "$3" ] && echo "Running cleanup" && "$3" # cleanup function
        exit 1
    fi
}
assert() {
    if [ "$1" -ne "$2" ]; then
        echo "Test failed ❌ ->" " Expected: $2 : Actual: $1"
        [ "$3" ] && echo "Running cleanup" && "$3" # cleanup function
        exit 1
    fi
}

test5_cleanup() {
    # delete the users using a loop and the delete_user function
    sudo groupdel proyectoX
    for user in usu1 usu2 usu3; do
        sudo userdel "$user"
        sudo rm -rf "/home/$user"
    done
    echo "Running cleanup for test 5 done"
}
crear_usuarios_tests() {
    # try to call the script wituhout being superuser
    echo "Running tests for crear_usuarios.sh"
    test_location="./scripts/crear_usuarios.sh"
    echo "Test 1: Not superuser, return should be 1"
    my_test "$(bash "$test_location" 2>&1)" 1

    echo "Test 2: Wrong number of argument, return should be 2"
    my_test "$(sudo bash "$test_location" 2>&1)" 2

    echo "Test 3: File/directory already exists in /srv with the same name as given group, return should be 3"
    sudo mkdir /srv/test_dir
    my_test "$(sudo bash "$test_location" test_dir fakeuser)" 3
    sudo rmdir /srv/test_dir

    echo "Test 4: Group that already exists, return should be 4"
    # create the group
    sudo groupadd fakegroup
    my_test "$(sudo bash "$test_location" fakegroup fakeuser 2>&1 >/dev/null)" 4
    # delete the group
    sudo groupdel fakegroup

    echo "Test 4: User that already exists, return should be 5"
    # create the user
    sudo useradd fakeuser
    my_test "$(sudo bash "$test_location" fakegroup fakeuser 2>&1 >/dev/null)" 5
    # delete the user
    sudo userdel fakeuser

    str="Test 5: Correct arguments, return should be 0:
        - users and group created and added
        - passwords should be set and displayed following the pattern
        - home directories should be created for each user
        - /srv/<group> should be created
        - permissions should be set correctly
        "
    echo "$str"

    password=$(sudo bash ./scripts/crear_usuarios.sh proyectoX usu1 usu2 usu3)
    ret_val="$?"
    echo "Test 5.1: Group should be created"
    my_test "$(
        sudo getent group proyectoX
        echo $?
    )" "0" test5_cleanup
    echo "Test 5.2: Users should be created"
    for user in usu1 usu2 usu3; do
        my_test "$(
            sudo getent passwd "$user"
            echo $?
        )" "0" test5_cleanup
    done
    echo -e "Test 5.3: Passwords should be set and displayed following the pattern: \n\tusu1:password1\n\tusu2:password2\n\tusu3:password3"
    # separate the password string into an array
    echo "$password"
    IFS='\n' read -r -a users_passwords <<<"$password"
    for user_password in "${users_passwords[@]}"; do
        # print the user and password
        echo -e "\tUser:passord => $user_password"
        # separate the user and password
        IFS=':' read -r -a user_password <<<"$user_password"
        # check if the password is correct
        my_test
        "$(
            IFS='$' read -r -a real_passwd_array <<<"$(sudo getent shadow "${user_password[0]}")"
            IFS='/' read -r -a real_hashed <<<"${real_passwd_array[3]}"
            IFS='$' read -r -a generated_passwd_array <<<"$(mkpasswd -m SHA-512 "${user_password[1]}" "${real_passwd_array[2]}")"
            IFS='/' read -r -a generated_hash <<<"${generated_passwd_array[3]}"
            # compare the hashes, store the result in a variable
            [ "${real_hashed[0]}" == "${generated_hash[0]}" ]
        )" 0 test5_cleanup
    done
    echo -e "\tTest 5.4: Return should be 0"
    assert ret_val 0 test5_cleanup
}

delete_user() {
    sudo userdel "$1"
    sudo rm -rf "/home/$1"
}

configurar_almacenamiento_tests() {
    echo "Not implemented yet"

}

kernel_log_tests() {
    echo "Not implemented yet"
}

nfs_tests() {
    echo "Not implemented yet"
}

maestro_tests() {
    echo "Not implemented yet"
}

selection_dialog
