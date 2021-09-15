package Bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String token;

    public static List<Event> events = new ArrayList<>();
    public static List<MemberVars> memberVars = new ArrayList<>();

    public static MemberVars getMemberVars(long id) {
        for (MemberVars vars : memberVars) {
            if (vars.getMemberId() == id) return vars;
        }
        return null;
    }

    public static void main(String[] args) {

        try {
            //Personal Location for the Token
            File tokenLocation = new File("GGDCDiscordBot.token");
            Scanner tokenIn = new Scanner(tokenLocation);
            token = tokenIn.nextLine();

            //Setup JDA, with GatewayIntents
            JDABuilder jdaBuilder = JDABuilder.create(token,
                    GatewayIntent.GUILD_MEMBERS,
                    GatewayIntent.GUILD_PRESENCES,
                    GatewayIntent.GUILD_MESSAGES
            ).setMemberCachePolicy(MemberCachePolicy.OWNER);

            jdaBuilder.addEventListeners(new Listener());

            //Start the bot
            try {
                JDA jda = jdaBuilder.build();
                jda.awaitReady();

                jda.upsertCommand("hello","says hello to the bot.").queue();
                jda.upsertCommand("ping","Calculate the ping of the bot.").queue();

                events.add(new Event("Siege 2018",2018,"Siege"));
                events.add(new Event("Global Game Jam 2019",2019,"Global Game Jam"));
                events.add(new Event("HI-Rez Studio Playtester",2019,"HI-Rez Studio Playtester"));
                events.add(new Event("Athens Game Jam 2019",2019,"Athens Game Jam"));
                events.add(new Event("KSU Game Jam 2019",2019,"KSU Game Jam"));
                events.add(new Event("Global Game Jam 2020",2020,"Global Game Jam"));
                events.add(new Event("Game Maker's Toolkit Game Jam 2020",2020,"Game Maker's Toolkit Game Jam"));

                Guild guild = jda.getGuildById(363035252068843522L);

                assert guild != null;
                List<Member> members = guild.getMembers();

                for (Member member : members) {

                    MemberVars vars = new MemberVars(member.getIdLong());
                    memberVars.add( vars );
                    for (Role role : member.getRoles()) {
                        for (Event event : events) {
                            if (role.getName().equals(event.getSearch())) {
                                event.addMemberAttended(member.getIdLong(),"temp_role");
                                vars.addEventAttended(event);
                                //System.out.println("Adding " + member.getEffectiveName() + " to " + event.getName());
                }   }   }   }

            } catch (LoginException | InterruptedException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Missing the Token, stopping program.");
        }

    }

}
