package Bot.Commands;

import Bot.Event;
import Bot.Main;
import Bot.MemberVars;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.time.temporal.TemporalUnit;

public class GetProfile extends Command{

    public GetProfile(MessageReceivedEvent e) {
        super(e);
    }

    public GetProfile(SlashCommandEvent slashCommand) {
        super(slashCommand);
    }

    @Override
    public void run() {
        EmbedBuilder embed = new EmbedBuilder();
        Member member = message.getMember();
        MemberVars vars = Main.getMemberVars(member.getIdLong());
        if (vars.getFirstName() != null) {
            if (vars.getLastName() != null) {
                embed.setAuthor(vars.getFullName());
            } else {
                embed.setAuthor(vars.getFirstName());
            }
        }
        if (vars.getSchoolEmail() != null) {
            embed.setDescription(vars.getSchoolEmail());
        }
        embed.setTitle(member.getUser().getName());
        for (Event event : vars.getEventsAttended()) {
            embed.addField(event.getNameFancy(),
                    event.getMembersAttended1().get(member.getIdLong()),
                    true
            );
        }
        embed.setThumbnail(message.getAuthor().getAvatarUrl());
        embed.setColor(member.getColor());
        embed.setTimestamp(member.getTimeJoined());
        sendMessage(embed.build());
    }
}
