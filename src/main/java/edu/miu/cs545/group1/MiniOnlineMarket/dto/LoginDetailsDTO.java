package edu.miu.cs545.group1.MiniOnlineMarket.dto;

public class LoginDetailsDTO {

        private String username;
        private String password;

        public LoginDetailsDTO() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
}
