package Bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class Main {

    final static String TOKEN = "Njc3NjcxNTU0ODA0NDgyMDU5.XkXo0Q.yIiUW1whvvV4nSq0TxEoj4In-bM";

    public static void main(String[] args) {

        JDABuilder jdaBuilder = JDABuilder.create(TOKEN,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_MESSAGES
        ).setMemberCachePolicy(MemberCachePolicy.OWNER);

        JDA jda;

        try {
            jda = jdaBuilder.build();
            jda.awaitReady();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
