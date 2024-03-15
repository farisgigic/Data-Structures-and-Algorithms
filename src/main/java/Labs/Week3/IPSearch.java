package Labs.Week3;

public class IPSearch {
    public static IPAddress search(IPAddress[] ipAddresses, String ipAddress) {
        // replace the method body with your code
        String[] octets = ipAddress.split("\\.");
        long ipNumber = 0;

        for (int i = 0; i < octets.length; i++) {
            ipNumber += Long.parseLong(octets[i]) * Math.pow(256, 3 - i);
        }

        for (IPAddress ip : ipAddresses) {
            if (ipNumber >= ip.getStartIp() && ipNumber <= ip.getEndIp()) {
                return ip;
            }
        }

        return null;
    }


}
