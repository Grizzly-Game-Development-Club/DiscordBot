package Bot.Commands;

import Bot.Main;
import Bot.MemberVars;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class SetMemberName extends Command{

    public SetMemberName(MessageReceivedEvent e) {
        super(e);
    }

    public SetMemberName(SlashCommandEvent slashCommand) {
        super(slashCommand);
    }

    @Override
    public void run() {
        String[] cmd = message.getContentRaw().split("\\s+");
        MemberVars vars = Main.getMemberVars(message.getMember().getIdLong());
        if (vars != null) {
            vars.setFirstName(cmd[1]);
            vars.setLastName(cmd[2]);
        }
    }
}
