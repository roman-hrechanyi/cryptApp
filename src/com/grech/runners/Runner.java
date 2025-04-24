package com.grech.runners;

import com.grech.services.CLIService;
import com.grech.services.CommandExecuteService;

import static com.grech.constants.Constants.ZERO_ARGS_COUNT;

public class Runner {
    private final CommandExecuteService commandExecuteService = new CommandExecuteService();

    public void run(String[] args) {
        if (args.length == ZERO_ARGS_COUNT) {
            args = CLIService.start();
        }
        commandExecuteService.execute(args);
    }
}
