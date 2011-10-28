package models.account;


import play.data.validation.Email;
import play.data.validation.Required;
import play.modules.morphia.Model;
import play.modules.morphia.Model.AutoTimestamp;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

@SuppressWarnings("serial")
@Entity
@AutoTimestamp
public class User extends Model{
	@Required
    public String userName;
    
    @Required
    public String password;
    
    public String fullname;
    
    public boolean isAdmin;
    
    @Reference
    public Role role;
    
    public User(String userName, String password, String fullname) {
        this.userName = userName;
        this.password = password;
        this.fullname = fullname;
    }
    
    public static User connect(String userName, String password) {
        return User.find("byUserNameAndPassword", userName, password).first();
    }
    
    public String toString() {
        return userName;
    }
}
