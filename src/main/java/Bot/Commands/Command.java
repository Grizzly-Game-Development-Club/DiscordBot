package Bot.Commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public abstract class Command {

    boolean isSlashCommand;
    TextChannel channel;
    SlashCommandEvent slashCommand;

    public Command(TextChannel channel) {
        this.isSlashCommand = false;
        this.channel = channel;

        run();
    }

    public Command(SlashCommandEvent slashCommand) {
        this.isSlashCommand = true;
        this.slashCommand = slashCommand;

        run();
    }

    public abstract void run();

    public void sendMessage(String msg) {
        if (isSlashCommand) {
            slashCommand.reply(msg).queue();
        } else {
            channel.sendMessage(msg).queue();
        }
    }

}
