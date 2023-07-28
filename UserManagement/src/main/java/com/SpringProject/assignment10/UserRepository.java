package com.SpringProject.assignment10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.SerializableString;

@Repository
public class UserRepository implements Serializable{

 

    private final String dataDir = "data/users/";

 

    public User save(User user) throws IOException {
        File file = new File(dataDir + user.getId() + ".ser");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(user);
        }
        return user;
    }

 

    public User findById(Long id) throws IOException, ClassNotFoundException {
        File file = new File(dataDir + id + ".ser");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (User) in.readObject();
        }
    }

 

    public List<User> findAll() throws IOException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        File dir = new File(dataDir);
        for (File file : dir.listFiles()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                users.add((User) in.readObject());
            }
        }
        return users;
    }



	public void delet(long id) {
		File file = new File(dataDir + id + ".ser");
		if(file.exists())
			file.delete();
	}
}