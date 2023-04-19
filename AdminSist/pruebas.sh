#! /bin/bash
user="pepperonico"
passwd_to_check=" "
IFS='$' read -r -a real_passwd_array <<<"$(sudo getent shadow "$user")"
IFS='/' read -r -a real_hashed <<<"${real_passwd_array[3]}"

echo "Generated password hash"
IFS='$' read -r -a generated_passwd_array <<<"$(mkpasswd -m SHA-512 "$passwd_to_check" "${real_passwd_array[2]}")"
IFS='/' read -r -a generated_hash <<<"${generated_passwd_array[3]}"

# compare
echo "Comparing hashes"
echo "Real hash: ${real_hashed[0]}"
echo "Generated hash: ${generated_hash[0]}"
if [ "${real_hashed[0]}" = "${generated_hash[0]}" ]; then
    echo "Hashes match"
else
    echo "Hashes don't match"
fi
