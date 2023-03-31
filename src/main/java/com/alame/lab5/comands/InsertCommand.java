package com.alame.lab5.comands;

import com.alame.lab5.elements.Receiver;
import com.alame.lab5.exceptions.IncorrectCommandParameterException;
import com.alame.lab5.exceptions.IncorrectElementFieldException;
import com.alame.lab5.input.UserInput;

/**
 * command for insert a pair of key and element in collection
 */
public class InsertCommand implements Command{
    private final Receiver receiver;
    private final UserInput userInput;
    private String key;
    public InsertCommand(Receiver receiver, UserInput userInput){
        this.receiver = receiver;
        this.userInput = userInput;
    }

    /**
     * insert a pair of key and element in collection
     * @return true if reading was successful else false
     */
    @Override
    public boolean execute(){
        try {
            receiver.insert(key, userInput.getStudyGroupReader().readStudyGroup());
            return true;
        }
        catch (IncorrectElementFieldException e){
            return false;
        }
    }

    /**
     * set key
     * @param parameters - all parameters of command
     * @throws IncorrectCommandParameterException if parameters size!=1
     */
    @Override
    public void setParameters(String[] parameters) throws IncorrectCommandParameterException {
        if (parameters.length!=1) throw new IncorrectCommandParameterException("Данная команда принимает 1 аргумент");
        else{
            key = parameters[0];
        }
    }

    /**
     * @return command description
     */
    @Override
    public String description() {
        return "insert key: добавляет новый элемент с заданным ключом";
    }
    /**
     * @return command description
     */
    @Override
    public String name() {
        return "insert";
    }

    /**
     * create new InsertCommand
     * @return new InsertCommand with same receiver and userInput
     */
    @Override
    public Command newInstance() {
        return new InsertCommand(receiver, userInput);
    }
}
