package module;

import java.lang.classfile.instruction.ReturnInstruction;
import java.util.ArrayList;

public class ClientManagement {
ArrayList<Client> clientlist= new ArrayList<Client>(); 
//    private ClientFileHandler clientFileHandler = new ClientFileHandler();
// this is the object of filehandling interms of client
   FileHandling clientFileHandling;
   public ClientManagement() {
       clientFileHandling=new FileHandling();
// this will read the file whenever the app is open
clientlist=clientFileHandling.readFromClientFile();
   }

    public boolean addClient(String f_name, String l_name, int plotnumber, int totalamount) {
        // Check if client with same plot number already exists
        for (Client client : clientlist) {
            if (client.getPlotnumber() == plotnumber) {
                return false;
            }
        }

        // Create new client object
        Client newClient = new Client(f_name, l_name, plotnumber, totalamount);

        // Add to client list
        clientlist.add(newClient);
        
        // Add client data to file (append = true to add at end)
  clientFileHandling.addToTheClient(newClient, true);

        return true;
    }

 // deleting method
    public boolean delClient(String f_name, String l_name, int plotnumber) {
        boolean removed = clientlist.removeIf(client ->
            client.getFirstName().equalsIgnoreCase(f_name) &&
            client.getLastname().equalsIgnoreCase(l_name) &&
            client.getPlotnumber() == plotnumber
        );
        if (removed) {
			clientFileHandling.updateClientFile(clientlist, false);
			System.out.println("The client is also deletd from rocords");
		}
            return removed;
}

    //function to search the client in the system
    public Client searchClient(int plotnumber, String f_name) {
        for (Client client : clientlist) {
            if (client.getFirstName().equalsIgnoreCase(f_name) && (client.getPlotnumber() == plotnumber)) {
                return client;
            }
        }
        return null;
    }

    public ArrayList<Client>  listClient() {
        if (clientlist.isEmpty()) {
            System.out.println("No clients found.");
            return null;
        } else {
            System.out.println("List of Clients:");
            for (Client client : clientlist) {
                System.out.println(client.toString());
            }
        }        
        return clientlist;

    }

    // function for upgrading all information of client
    // Method to update client info based on plot number and desired field (to be triggered from GUI)
    public boolean updateClientInfo(int plotnumber, String fieldToUpdate, String newValue) {
        // we are using new value as string because java swing stores every value as string
        for (Client client : clientlist) {
            if (client.getPlotnumber() == plotnumber) {
                switch (fieldToUpdate.toLowerCase()) {
                    case "firstname":
                        client.setFirstName(newValue);
                        break;

                    case "lastname":
                        client.setLastname(newValue);
                        break;

                    case "cnic":
                        client.setCnic(newValue);
                        break;

                    case "totalamount":
                        try {
                            int amount = Integer.parseInt(newValue);
                            client.setTotalmount(amount);
                        } catch (NumberFormatException e) {
                            return false;
                        }
                        break;

                    case "areaplot":
                        try {
                            double area = Double.parseDouble(newValue);
                            client.setAreaplot(area);
                        } catch (NumberFormatException e) {
                            return false;
                        }
                        break;

                    default:
                        return false;
                }
                // After updating the client info, update the file
                clientFileHandling.updateClientFile(clientlist, false); // false to overwrite the file
                return true;  // return true after successfully updating and saving
            }
        }
        return false; // client not found
    }

    }

  