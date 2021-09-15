package Bot.Commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class HelloWorld extends Command {


    public HelloWorld(TextChannel channel) {
        super(channel);
    }

    public HelloWorld(SlashCommandEvent slashCommand) {
        super(slashCommand);
    }

    @Override
    public void run() {
        sendMessage("Hello World!");
    }

}
