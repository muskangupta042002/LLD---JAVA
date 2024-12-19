package org.muskan.remote;

import org.muskan.Command;

public class NoCommand implements Command {
    public void execute(){
        System.out.println("Don't do anything, I am no command!! ");
    }
}
