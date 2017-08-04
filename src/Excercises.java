public class Excercises {
	

public static void main(String args[])
{
	//SnakeEyes();
	//MaxDivisors();
	//calculateExpression();
	//breakIntoWords();
	//aggregateSales();
	//MaxDivisorsImproved();
	
	BirthdaysImproved();
}
public static void BirthdaysImproved()
{
	boolean condition1 = false, condition2 = false, condition3 = false;
	int birthday = 0, differentBirthdaysCount = 0, differentBirthdaysFor365 = 0, differentPeopleFor365 = 0, differentPeopleFor3 = 0, count = 0;
	int[] birthdays = new int[366];
	
	while (!condition1 || !condition2 || !condition3)
	{
		count ++;
		
		birthday = (int)(Math.random()*365)+1;
		birthdays[birthday]++;
		if (birthdays[birthday] == 1)
		{
			differentBirthdaysCount ++;
		}
		if ((count == 365)&&(!condition2))
		{
			differentBirthdaysFor365 = differentBirthdaysCount;
			condition2 = true;
		}
		if ((birthdays[birthday] == 3) && (!condition1))
		{			
			condition1 = true;
			differentPeopleFor3 = count; 
		}
		if ((differentBirthdaysCount == 365)&&(!condition3))
		{
			condition3 = true;
			differentPeopleFor365 = count;
		}
		
	}
	
	System.out.printf("%d random people we had to select to find three people with the same birthday\n", differentPeopleFor3);
	System.out.printf("365 selected people had %d different birthdays\n", differentBirthdaysFor365);
	System.out.printf("%d different people we had to check before we've found at least one person with a birthday on each of the 365 days of the year\n", differentPeopleFor365);
}
public static void MaxDivisorsImproved()
{
	int[] divisorsCount = new int[10000];
	int currentCount = 0, maxCount = 0;
	
	for (int i=0;i<10000;i++)
	{
		currentCount=0;
		for (int k=1; k<=i; k++)
		{
			if (i % k == 0)
				currentCount++;
		}
		divisorsCount[i]=currentCount;
		if (maxCount < currentCount)
			maxCount = currentCount;
	}
	System.out.printf("The biggest number of divisors is : %d\n", maxCount);
	System.out.println("Number with the biggest number of divisors:\n");
	for (int i=0;i<10000;i++)
	{
		if (divisorsCount[i] == maxCount)
			System.out.printf("%d\n",i);
			
	}
}
public static void aggregateSales()
{
	String row;
	int colonIndex = 0, numberOfNoDataCities = 0;
	double sum = 0, sale = 0;
	
	TextIO.readUserSelectedFile();
	while (!TextIO.eof())
	{
		row = TextIO.getlnString();
		colonIndex = row.indexOf(':');
		if (colonIndex != -1)
		{
			try
			{
				sale = Double.parseDouble(row.substring(colonIndex+1, row.length()));
				System.out.printf("%1.2f\n", sale);
				sum += sale;
			}
			catch(NumberFormatException ex)
			{
				numberOfNoDataCities++;
			}
		}
		else 
		{
			System.out.printf("Wrong input type format. Exiting\n");
			return;
		}
			
	}
	System.out.printf("Aggregated sum of sales from all cities is %2.2f\n", sum);
	System.out.printf("Number of cities missing sales is %d\n", numberOfNoDataCities);
}
public static void breakIntoWords()
{
	String input;
	int i = 0, start = 0, finish = 0;
	System.out.println("Please enter your text:\n");
	input = TextIO.getlnString();
	input = " "+input+ " ";
	
	while (i < input.length())
	{
		if (!Character.isLetter(input.charAt(i)))
		{
			start = finish;
			finish = i;
			if (finish - start >1)
			System.out.println(input.substring(start+1, finish));
		}
		i++;
	}
}
public static void calculateExpression()
{
	String expression;
	double firstValue, secondValue;
	char operation;
	
	while (true)
	{
		System.out.printf("Enter an expression (\"0\" to exit):\n");
		expression = TextIO.getlnString();
		if (expression == "0")
			break;
		int position = -1;
		
		if (expression.indexOf("+") != -1)
			position = expression.indexOf("+");
		else
		if (expression.indexOf("-") != -1)
			position = expression.indexOf("-");
		else 
		if (expression.indexOf("*") != -1)
			position = expression.indexOf("*");
		else
		if (expression.indexOf("/") != -1)
			position = expression.indexOf("/");
		
		if (position == -1)
			continue;
		try 
		{
			firstValue = Double.parseDouble(expression.substring(0, position));
			secondValue = Double.parseDouble(expression.substring(position+1, expression.length()));
			operation = expression.charAt(position);
		}
		catch (NumberFormatException Ex)
		{
			System.out.println("Wrong input format" + Ex.getMessage());
			continue;
		}
		
		switch (operation)
		{
		case '+':
			System.out.printf("Result of the operation is: %1.2f\n", firstValue + secondValue);
			break;
		case '-':
			System.out.printf("Result of the operation is: %1.2f\n", firstValue - secondValue);
			break;
		case '/':
			System.out.printf("Result of the operation is: %1.2f\n", firstValue / secondValue);
			break;
		case '*':
			System.out.printf("Result of the operation is: %1.2f\n", firstValue * secondValue);
			break;
		default:
			System.out.println("Wrong input");
		}
	}
}
public static void MaxDivisors()
{
	int currentCount = 0, maxCount = 0;
	int currentNum = 0, maxNum = 0;
	
	while (currentNum<10000)
	{
		currentNum++;
		currentCount=0;
		for (int i=1; i<currentNum; i++)
		{
			if (currentNum % i == 0)
				currentCount++;
		}
		if (currentCount > maxCount)
		{
			maxCount = currentCount;
			maxNum = currentNum;
		}
	}
	System.out.printf("%d has the biggest number of divisors : %d", maxNum, maxCount+1);
}
public static void SnakeEyes()
{
	int roll1, roll2, count;
	char input;
	
	while (true)
	{
		System.out.println("Please press any key to continue and \"0\" if you want to exit");
		input = TextIO.getAnyChar();
		if (input == '0')
			break;
		count = 0;
		while (true)
		{
			count++;
			roll1 = ((int)(Math.random()*6))+1;
			roll2 = ((int)(Math.random()*6))+1;
			if ((roll1 == 1)&&(roll2 == 1))
				break;
		}
		System.out.printf("Number of dices rolls required to get Snakes eyes is %d\n", count);	
	}
}

}