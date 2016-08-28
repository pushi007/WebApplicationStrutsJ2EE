package com.tvm.ilp.t154.cao.encdec;

public class a {

	 public static void main(String[] args)
	    {
	    	System.out.println("GM");
	    	try {
	    		
	    		String b="100017_1989/02/09";
	    		String a=SecurePassword.encrypt(b);
	    		
				System.out.println(b+"->"+a+" : "+SecurePassword.decrypt(a));
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
	    }
}
