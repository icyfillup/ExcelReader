
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.xml.sax.SAXException;

public class MainActivity
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ERRA erra = null;
		Referral referral = null;
		VaProviderNetwork vpNetwork = null;
		try
		{
			/*
			erra = new ERRA(
					"D:\\My Document\\My stuff\\Google Drive\\Current Term Work\\CS Senior Design\\QTC\\sample data\\Sample ERRA Data");
			referral = new Referral(
					"D:\\My Document\\My stuff\\Google Drive\\Current Term Work\\CS Senior Design\\QTC\\sample data\\Sample referral data v2.xlsx");
			vpNetwork = new VaProviderNetwork(
					"D:\\My Document\\My stuff\\Google Drive\\Current Term Work\\CS Senior Design\\QTC\\sample data\\VA Provider Network List_non VetFed_083117.xlsx");
			*/
			
			erra = new ERRA("D:\\Google_Drive\\Current Term Work\\CS Senior Design\\QTC\\sample data\\Sample ERRA Data.xlsx");
			referral = new Referral("D:\\Google_Drive\\Current Term Work\\CS Senior Design\\QTC\\sample data\\Sample referral data v2.xlsx");
			vpNetwork= new VaProviderNetwork("D:\\Google_Drive\\Current Term Work\\CS Senior Design\\QTC\\sample data\\VA Provider Network List_non VetFed_083117.xlsx");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (OpenXML4JException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("DONE");

		MainMenu(erra, referral, vpNetwork);
	}

	public static void MainMenu(ERRA erra, Referral referral, VaProviderNetwork vpNetwork)
	{
		boolean isRunning = true;
		Scanner reader = new Scanner(System.in); // Reading from System.in

		while(isRunning)
		{
			System.out.println("\nMain Menu");
			System.out.println("\t0: Exit");
			System.out.println("\t1: List of Claimants by State and date");
			System.out.println("\t2: List of Provider by Zipcode");
			System.out.println("\t3: List of Claimants by State");
			System.out.println("\t4: List all Claimants");
			System.out.print(">>>>> ");
			int n = reader.nextInt(); // Scans the next token of the input as an
										// int.
			System.out.println();

			if(n == 0)
			{
				isRunning = false;
			}
			else if(n == 1)
			{
				System.out.print("Enter State (XX): ");
				String State = reader.next();

				System.out.print("Enter data (MM/dd/yyyy): ");
				String Date = reader.next();

				for(Referral.Claimant claimant : referral.ListOfClaimant)
				{
					if(claimant.State.equals(State))
					{
						if(claimant.Date.equals(Date))
						{
							System.out.println(claimant.toString());

						}
					}
				}
			}
			else if(n == 2)
			{
				System.out.print("Enter Zipcode: ");
				String Zipcode = reader.next();

				for(VaProviderNetwork.Provider provider : vpNetwork.ListOfProvider)
				{
					if(provider.ZipCode.equals(Zipcode))
					{
						System.out.println(provider.toString());
					}
				}
			}
			else if(n == 3) 
			{
				System.out.print("Enter State (XX): ");
				String State = reader.next();

				int count = 0;
				for(Referral.Claimant claimant : referral.ListOfClaimant)
				{
					if(claimant.State.equals(State))
					{
						System.out.println(claimant.toString());
						count++;
					}
				}
				
				System.out.println("\nCount: " + count);
			}
			else if(n == 4) 
			{
				int count = 0;
				for(Referral.Claimant claimant : referral.ListOfClaimant)
				{
					System.out.println(claimant.toString());
					count++;
				}
				
				System.out.println("\nCount: " + count);
			}

		}
		

		reader.close();
	}
}
