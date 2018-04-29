package com.tgj.eventaid.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class users {
    @Entity
    @Table(name="users")
    public class Users {

        @Id
        @GeneratedValue
        @Column(columnDefinition = "INT(12) UNSIGNED")
        private long id;

        @Column(nullable = false)
        private String firstname;

        @Column(nullable = false)
        private String lastname;

        @Column(nullable = false)
        private String address;

        @Column(nullable = false)
        private String email;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false)
        private String telephone;

        @Column(nullable = false)
        private String createdon;

        @Column(nullable = false)
        private boolean owner;

        public Users(String firstname, String lastname, String address, String email, String password, String telephone, String createdon, boolean owner) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.address = address;
            this.email = email;
            this.password = password;
            this.telephone = telephone;
            this.createdon = createdon;
            this.owner = owner;
        }

        public Users(long id, String firstname, String lastname, String address, String email, String password, String telephone, String createdon, boolean owner) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.address = address;
            this.email = email;
            this.password = password;
            this.telephone = telephone;
            this.createdon = createdon;
            this.owner = owner;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getCreatedon() {
            return createdon;
        }

        public void setCreatedon(String createdon) {
            this.createdon = createdon;
        }

        public boolean isOwner() {
            return owner;
        }

        public void setOwner(boolean owner) {
            this.owner = owner;
        }
    }
}
