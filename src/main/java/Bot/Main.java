package Bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static String token;

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

            } catch (LoginException | InterruptedException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            System.out.println("Missing the Token, stopping program.");
        }

    }

}
