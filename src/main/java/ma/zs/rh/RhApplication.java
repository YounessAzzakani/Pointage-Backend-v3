package ma.zs.rh;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.EnableFeignClients;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ma.zs.rh.bean.core.commun.Agent;
import ma.zs.rh.service.facade.admin.commun.AgentAdminService;
import ma.zs.rh.zynerator.security.bean.*;
import ma.zs.rh.zynerator.security.common.AuthoritiesConstants;
import ma.zs.rh.zynerator.security.service.facade.*;


import ma.zs.rh.zynerator.security.bean.User;
import ma.zs.rh.zynerator.security.bean.Role;

@SpringBootApplication
//@EnableFeignClients
public class RhApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(RhApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService, ModelPermissionService modelPermissionService, ActionPermissionService actionPermissionService, ModelPermissionUserService modelPermissionUserService , AgentAdminService agentService) {
    return (args) -> {
        if(true){


        // ModelPermissions
        List<ModelPermission> modelPermissions = new ArrayList<>();
        addPermission(modelPermissions);
        modelPermissions.forEach(e -> modelPermissionService.create(e));
        // ActionPermissions
        List<ActionPermission> actionPermissions = new ArrayList<>();
        addActionPermission(actionPermissions);
        actionPermissions.forEach(e -> actionPermissionService.create(e));

		// User Agent
        Agent userForAgent = new Agent("agent");
		userForAgent.setPassword("123");
		// Role Agent
		Role roleForAgent = new Role();
		roleForAgent.setAuthority(AuthoritiesConstants.AGENT);
		roleForAgent.setCreatedAt(LocalDateTime.now());
		Role roleForAgentSaved = roleService.create(roleForAgent);
		RoleUser roleUserForAgent = new RoleUser();
		roleUserForAgent.setRole(roleForAgentSaved);
		if (userForAgent.getRoleUsers() == null)
			userForAgent.setRoleUsers(new ArrayList<>());

		userForAgent.getRoleUsers().add(roleUserForAgent);
		if (userForAgent.getModelPermissionUsers() == null)
			userForAgent.setModelPermissionUsers(new ArrayList<>());


        userForAgent.setModelPermissionUsers(modelPermissionUserService.initModelPermissionUser());

        agentService.create(userForAgent);

		// User Admin
        User userForAdmin = new User("admin");
		userForAdmin.setPassword("123");
		// Role Admin
		Role roleForAdmin = new Role();
		roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
		roleForAdmin.setCreatedAt(LocalDateTime.now());
		Role roleForAdminSaved = roleService.create(roleForAdmin);
		RoleUser roleUserForAdmin = new RoleUser();
		roleUserForAdmin.setRole(roleForAdminSaved);
		if (userForAdmin.getRoleUsers() == null)
			userForAdmin.setRoleUsers(new ArrayList<>());

		userForAdmin.getRoleUsers().add(roleUserForAdmin);
		if (userForAdmin.getModelPermissionUsers() == null)
			userForAdmin.setModelPermissionUsers(new ArrayList<>());


        userForAdmin.setModelPermissionUsers(modelPermissionUserService.initModelPermissionUser());

        userService.create(userForAdmin);

            }
        };
    }




    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }


    private static void addPermission(List<ModelPermission> modelPermissions) {
        modelPermissions.add(new ModelPermission("EtatRetard"));
        modelPermissions.add(new ModelPermission("EntiteAdministrative"));
        modelPermissions.add(new ModelPermission("DemandeDocumentAdministratif"));
        modelPermissions.add(new ModelPermission("HeureSupplementaire"));
        modelPermissions.add(new ModelPermission("MotifRejetDemandeConge"));
        modelPermissions.add(new ModelPermission("DemandeAbsence"));
        modelPermissions.add(new ModelPermission("EtatDemandeDocumentAdministratif"));
        modelPermissions.add(new ModelPermission("PaiementAgent"));
        modelPermissions.add(new ModelPermission("JustificationRetard"));
        modelPermissions.add(new ModelPermission("PlageHoraire"));
        modelPermissions.add(new ModelPermission("DemandeConge"));
        modelPermissions.add(new ModelPermission("Agent"));
        modelPermissions.add(new ModelPermission("RaisonAbsence"));
        modelPermissions.add(new ModelPermission("Pointage"));
        modelPermissions.add(new ModelPermission("TypeHeureSupplementaire"));
        modelPermissions.add(new ModelPermission("Poste"));
        modelPermissions.add(new ModelPermission("MotifRejetDemandeAbsence"));
        modelPermissions.add(new ModelPermission("Retard"));
        modelPermissions.add(new ModelPermission("EtatDemandeConge"));
        modelPermissions.add(new ModelPermission("TypeDocumentAdministratif"));
        modelPermissions.add(new ModelPermission("RaisonConge"));
        modelPermissions.add(new ModelPermission("EtatDemandeAbsence"));
        modelPermissions.add(new ModelPermission("EtatTypeHeureSupplementaire"));
        modelPermissions.add(new ModelPermission("User"));
        modelPermissions.add(new ModelPermission("ModelPermission"));
        modelPermissions.add(new ModelPermission("ActionPermission"));
    }

    private static void addActionPermission(List<ActionPermission> actionPermissions) {
        actionPermissions.add(new ActionPermission("list"));
        actionPermissions.add(new ActionPermission("create"));
        actionPermissions.add(new ActionPermission("delete"));
        actionPermissions.add(new ActionPermission("edit"));
        actionPermissions.add(new ActionPermission("view"));
        actionPermissions.add(new ActionPermission("duplicate"));
    }


}


