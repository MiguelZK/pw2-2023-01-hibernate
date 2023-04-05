package dev.ifrs;

import dev.ifrs.model.Channel;
import dev.ifrs.model.Message;
import dev.ifrs.model.User;
import jakarta.ws.rs.Produces;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
public class Api {

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional //Pode estar no nível do método (como está) e pode estar no nível de classe
    public User createUser(@FormParam("name") String name) {
        
        // Esse modelo é apenas para este exemplo.
        // Um modelo de arquitetura correto separaria esta parte (web) da parte de regra de negócio.
        Channel channel = new Channel();
        channel.setHash("canal01");
        channel.persist();

        User user = new User();
        user.setName(name);
        user.addChannel(channel);
        user.persist();
        return user;

    }

}
