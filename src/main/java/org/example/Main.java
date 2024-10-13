package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();

        DatabaseQueryService queryService = new DatabaseQueryService(dataBase.getFlyway());

        List<MaxProjectCountClient> maxProjectsClients = queryService.findMaxProjectsClient();
        List<LongestProject> longestProjects = queryService.findLongestProject();
        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
        List<YoungestEldestWorker> youngestElderWorkers = queryService.findYoungestEldestWorker();

        for (MaxProjectCountClient client : maxProjectsClients) {
            System.out.println("Client: " + client.getName() +
                    ", Project Count: " + client.getProjectCount());
        }

        for (LongestProject project : longestProjects) {
            System.out.println("Project: " + project.getProjectName() +
                    ", Longest duration: " + project.getLongestDuration());
        }

        for (MaxSalaryWorker worker : maxSalaryWorkers) {
            System.out.println("Worker name - " + worker.getWorkerName() +
                    ", Max salary - " + worker.getSalary());
        }

        for (YoungestEldestWorker worker : youngestElderWorkers) {
            System.out.println("Type - " + worker.getType() + ", Worker name - " + worker.getWorkerName() +
                    ", Birthday - " + worker.getBirthday());
        }

        ClientService clientService = new ClientService(dataBase.getFlyway());

        try {
            long clientId = clientService.create("John Doe");
            System.out.println("Created client with ID: " + clientId);

            String clientName = clientService.getById(clientId);
            System.out.println("Client name: " + clientName);

            clientService.setName(clientId, "Jane Doe");
            System.out.println("Updated client name: " + clientService.getById(clientId));

            List<Client> clients = clientService.listAll();
            System.out.println("All clients: " + clients);

            clientService.deleteById(clientId);
            System.out.println("Deleted client with ID: " + clientId);
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}
