package Bot.Commands;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Ping extends Command {

    long time;

    public Ping(MessageReceivedEvent e) {
        super(e);
    }

    public Ping(SlashCommandEvent slashCommand) {
        super(slashCommand);
    }

    @Override
    public void run() {
        time = System.currentTimeMillis();
        sendMessage("Pong!");
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("Trying to send message : " + msg);
        if (isSlashCommand) {
            slashCommand.reply(msg).setEphemeral(true)
                    .flatMap(v ->
                            slashCommand.getHook().editOriginalFormat("Pong: %d ms",System.currentTimeMillis() - time)
                    ).queue();
        } else {
            channel.sendMessage(msg).queue(
                    message -> message.editMessageFormat("Pong %d ms", System.currentTimeMillis() - time).queue()
            );
        }
    }
}
