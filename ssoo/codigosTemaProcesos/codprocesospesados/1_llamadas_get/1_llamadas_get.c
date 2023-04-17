#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(void){

	pid_t pid, ppid;
	uid_t uid, gid, euid, egid;

	pid = getpid();
	printf("PID: %d\n", pid);
	
	ppid = getppid();
	printf("PPID: %d\n", ppid);

	uid = getuid();
	printf("UID: %d\n", uid);
	
	gid = getgid();
	printf("GID: %d\n", gid);

	euid = geteuid();
	printf("EUID: %d\n", euid);
	
	egid = getegid();
	printf("EGID: %d\n", egid);

	printf("PATH: %s\n", getenv("PATH"));
	
	return 0;	
}
