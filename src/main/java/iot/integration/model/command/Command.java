package iot.integration.model.command;

public interface Command {
    public void execute(String commandValue) throws Exception;
}
