				-- Schema database -- 
				
				CREATE TABLE t_customer(
					id INT AUTO_INCREMENT,
					fristName VARCHAR(225) NOT NULL,
					secondName VARCHAR(225) NOT NULL,
					emails VARCHAR(225) UNIQUE NOT NULL, 
					phone VARCHAR(225) NOT NULL,
					 PRIMARY KEY(ID)
				) Engine = InnoDB;			
				
				INSERT INTO t_customer(id, firstName, secondName, emails, phone) 
				VALUES (1, 'Madi', 'Andi', 'madiandi93@gmail.com', '085867729783'),
							 (2, 'Dima', 'Gosling', 'dimagosling@gmail.com', '085867729782'),
							 (3, 'Dian', 'Gosling', 'diangosling@gmail.com', '085867729784');
				
				-- Dependency maven--
				mysql-connector
				
				
				-- Keperluan untuk test --
				
				// 1 - test insert
				CustomerService service = new CustomerService();
        service.setDataSource(dataSource);
        
        Customer c = new Customer();
        c.setFirstName("Dian");
        c.setSecondName("Goslings");
        c.setEmails("diangosling@gmail.com");
        c.setPhone("085867729783");
        service.save(c);
				
				// 2 - test update byId
				CustomerService service = new CustomerService();
        service.setDataSource(dataSource);

        Customer c = service.getCustomerById(3);
        c.setSecondName("Gosling");
        c.setPhone("085867729784");
        service.save(c);
        
        // 3 - test update byEmail
        CustomerService service = new CustomerService();
        service.setDataSource(dataSource);
        Customer c = service.getCustomerByEmail("dimagosling@gmail.com");
        
        c.setPhone("085867729782");
        service.save(c);
        
				// 4 - test delete 
				CustomerService service = new CustomerService();
        service.setDataSource(dataSource);
        
        Customer c = service.getCustomerById(4);
        service.delete(c);

				
				// 5 - test getById
				CustomerService service = new CustomerService();
        service.setDataSource(dataSource);
        
        Customer c = service.getCustomerById(1);
        System.out.println("firstName : " + c.getFirstName());
        System.out.println("secondName : " + c.getSecondName());
        System.out.println("emails : " + c.getEmails());
        System.out.println("phone : " + c.getPhone());
        
        // 6 - test getByEmail
        CustomerService service = new CustomerService();
        service.setDataSource(dataSource);
        
        Customer c = service.getCustomerByEmail("madiandi93@gmail.com");
        System.out.println("firstName : " + c.getFirstName());
        System.out.println("secondName : " + c.getSecondName());
        System.out.println("emails : " + c.getEmails());
        System.out.println("phone : " + c.getPhone());
