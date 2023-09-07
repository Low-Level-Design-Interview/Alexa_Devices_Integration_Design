//package iot.integration.model;
//
//import java.util.Objects;
//
//public class Command {
//    String command;
//
//    public Command(String command) {
//        this.command = command;
//    }
//
//    public String getCommand() {
//        return command;
//    }
//
//    public void setCommand(String command) {
//        this.command = command;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Command)) return false;
//        Command command1 = (Command) o;
//        return getCommand().equals(command1.getCommand());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getCommand());
//    }
//}
