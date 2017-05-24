package ftpServer;

/**
 * informations sur l'utilisateurs
 */
public class UserInfos {
	String user;
	String password;
	String workDir;

	//fonction qui ajoute un nouvel utilisateur
    public static UserInfos loadUsersInfo(String user, String password, String workDir){

        UserInfos tempUserInfos = new UserInfos();
        tempUserInfos.user=user;
        tempUserInfos.password=password;
        tempUserInfos.workDir=workDir;
        return tempUserInfos;
    }// LoadUsersInfo () end

}
