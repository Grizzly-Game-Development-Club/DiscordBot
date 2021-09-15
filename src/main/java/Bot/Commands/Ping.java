package Bot.Commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class Ping extends Command {

    long time;

    public Ping(TextChannel channel) {
        super(channel);

        time = System.currentTimeMillis();
    }

    public Ping(SlashCommandEvent slashCommand) {
        super(slashCommand);

        time = System.currentTimeMillis();
    }

    @Override
    public void run() {
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
