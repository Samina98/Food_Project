public class Participant {
    private int id;
    private String name,phone,email,password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    /**
     * 
     * @param name enter <b>users</b> name here
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;        
    }  
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }

   
 
}