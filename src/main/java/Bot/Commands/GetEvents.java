package Bot.Commands;

import Bot.Event;
import Bot.Main;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class GetEvents extends Command{

    public GetEvents(MessageReceivedEvent e) {
        super(e);
    }

    public GetEvents(SlashCommandEvent slashCommand) {
        super(slashCommand);
    }

    @Override
    public void run() {

        System.out.println("Running Command");

        StringBuilder str = new StringBuilder();
        for (Event event: Main.events) {
            str.append(event.toString()).append("\n");
        }
        sendMessage(str.toString());
    }
}
