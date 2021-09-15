package Bot.Commands;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class HelloWorld extends Command {


    public HelloWorld(MessageReceivedEvent messageEvent) {
        super(messageEvent);
    }

    public HelloWorld(SlashCommandEvent slashCommand) {
        super(slashCommand);
    }

    @Override
    public void run() {
        sendMessage("Hello World!");
    }

}
