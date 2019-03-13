package com.canvas.drawing;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.canvas.command.CommandService;
import com.canvas.command.CommandType;
import com.canvas.command.CreateCommand;
import com.canvas.command.DrawLineCommand;
import com.canvas.command.DrawRectangleCommand;
import com.canvas.exception.InvalidCommandException;
import com.canvas.exception.InvalidParameters;

public class CommandServiceTest {

    private CommandService commandService;

    @Before
    public void setUp() throws Exception {
    	commandService = new CommandService();
    }

    @Test
    public void getCommand1() throws Exception {
    	commandService.getCommandType("Q");
    }

    @org.junit.Test(expected = InvalidCommandException.class)
    public void getCommand2() throws Exception {
    	commandService.getCommandType("A");
    }

    @Test
    public void getCommand3() throws Exception {
        CommandType commandType = commandService.getCommandType("C 20 4");
        Assert.assertThat(commandType, CoreMatchers.instanceOf(CreateCommand.class));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void getCommand4() throws Exception {
    	commandService.getCommandType("C 20 -4");
    }

    @Test
    public void getCommand5() throws Exception {
    	CommandType commandType = commandService.getCommandType("L 1 2 1 22");
        Assert.assertThat(commandType, CoreMatchers.instanceOf(DrawLineCommand.class));
    }

    @org.junit.Test(expected = InvalidParameters.class)
    public void getCommand6() throws Exception {
    	commandService.getCommandType("L 1 2 1 -22");
    }

    @Test
    public void getCommand7() throws Exception {
    	CommandType commandType = commandService.getCommandType("R 14 1 18 3");
        Assert.assertThat(commandType, CoreMatchers.instanceOf(DrawRectangleCommand.class));
    }

    @org.junit.Test(expected = InvalidParameters.class)
    public void getCommand8() throws Exception {
    	commandService.getCommandType("R 14 1 18 -3");
    }

    @Test
    public void getCommand9() throws Exception {
    }

    @org.junit.Test(expected = InvalidParameters.class)
    public void getCommand10() throws Exception {
    	commandService.getCommandType("B 1 3 oo");
    }


}