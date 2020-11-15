import java.util.*;
class Address {

	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String zip;
	String phone;

	public Address(String firstName, String lastName, String address, String city, String state, String zip, String phone) {
		this.firstName=firstName;
		this.lastName=lastName;
	        this.address=address;
        	this.city=city;
	        this.state=state;
        	this.zip=zip;
	        this.phone=phone;
	}

	public static Comparator<Address> addressComparator = new Comparator<Address>() {
		public int compare(Address a1, Address a2) {
			String s1=a1.lastName.toUpperCase();
			String s2=a2.lastName.toUpperCase();

			return s1.compareTo(s2);
		}
	};

	public String toString() {
		return "Address is \n" + firstName+" "+lastName+"\n"+address+"\n"+city+"\n"+state+"\n"+zip+"\n"+phone;
	}
}
public class AddressBook {

	private LinkedList<Address> addressList;

	public AddressBook() {
		addressList = new LinkedList<>();
	}

	public void addAddress(String firstName, String lastName, String address, String city, String state, String zip, String phone) {
		Address addr = new Address(firstName,lastName,address,city,state,zip,phone);
		addressList.add(addr);
	}

	public void showAddress() {
		for (int i=0;i<addressList.size();i++) {
			Address ad = addressList.get(i);
			System.out.println("\n"+ad);
		}
	}
	public void showAddressSorted() {
		Collections.sort(addressList, Address.addressComparator);
		for (Address a: addressList) {
			System.out.println("\n"+a);
		}
	}

	public static void main(String[] args) {
		AddressBook a = new AddressBook();
		a.addAddress("Vamshi","Krishna","sripathi nagar","adilabad","Telangana","504231","1234567890");
		a.addAddress("vasavi","kumar","dispur","godavarihani","MadhyaPradesh","855254","9994235890");
		a.addAddress("Vijay","Devarakonda","santhpur","Jabalpur","Chattisgarh","502145","1111567890");
		a.addAddress("vikas","acharya","centenary colony","Bangalore","Karnataka","751132","9994678903");
		a.showAddress();
		System.out.println("Address in sorted order by lastname is");
		a.showAddressSorted();
	}
}

