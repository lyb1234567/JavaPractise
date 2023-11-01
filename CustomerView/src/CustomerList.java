public class CustomerList {

    private Customer [] customers;
    private int total;

    public CustomerList(int totalCustomer) {
        customers=new Customer[totalCustomer];
    }
    public boolean addCustomer(Customer customer)
    {
        if(total<customers.length)
        {
            customers[total]=customer;
            total++;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean replaceCustomer(Customer customer,int index)
    {
        if(index>=0 && index<customers.length)
        {
            customers[index]=customer;
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(int index)
    {
        if(index<0 || index>=customers.length)
        {
            return false;
        }
        for(int i=index;i<total-1;i++)
        {
            customers[i]=customers[i+1];
        }
        customers[total-1]=null;
        total--;
        return true;
    }

    public Customer[] getCustomers(int index) {
        Customer[] cuts=new Customer[total];
        for(int i=0;i<customers.length;i++)
        {
            cuts[i]=customers[i];
        }
        return cuts;

    }

    public Customer getCustomer(int index)
    {
        if (index>=0 && index<customers.length)
        {
            return customers[index];
        }
        return null;
    }

    public int getTotal() {
        return total;
    }
}
