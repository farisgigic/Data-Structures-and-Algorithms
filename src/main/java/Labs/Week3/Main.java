package Labs.Week3;

public class Main {
    public static void main(String[] args) {
        // Read IP addresses from file
        IPAddress[] ipAddresses = FileUtils.readFile("C:\\Users\\pc\\Desktop\\DataStructures\\IP2LOCATION.csv");

        // Search for a specific IP address
        String ipAddressToSearch = "202.186.13.4";
        IPAddress foundIpAddress = IPSearch.search(ipAddresses, ipAddressToSearch);

        // Display the result
        if (foundIpAddress != null) {
            System.out.println("IP Address found:");
            System.out.println("Start IP: " + foundIpAddress.getStartIp());
            System.out.println("End IP: " + foundIpAddress.getEndIp());
            System.out.println("Country Code: " + foundIpAddress.getCountryCode());
            System.out.println("Country: " + foundIpAddress.getCountry());
            System.out.println("Region: " + foundIpAddress.getRegion());
            System.out.println("City: " + foundIpAddress.getCity());
        } else {
            System.out.println("IP Address not found.");
        }
    }
}
