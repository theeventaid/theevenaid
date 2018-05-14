USE tea_db;

insert into users (address,
       email, firstname, lastname, owner, password, telephone)
values
('11250 Briar Forest Drive, Houston 77042','admin@gmail.com', 'Mau', 'Fernandez',1, '$2a$10$8GKoJXj.zbB0KF5q7G72x.MD9XBCCB8KONfFaVSMS7wKvePMKV2Xe', '8321234455'),
('1234 Forest, Houston 77042', 'user@user.com','Peter', 'Johnson', 0, '$2a$10$hEM3jQcqZw3NkI6YnE4uR./dFIGVkunxwtuLBLBPuNHc0vB.xd9JG', '1234567890'),
('12 Wolf Drive, Houston 77042', 'user1@user.com','John', 'Smith', 0, '$2a$10$hEM3jQcqZw3NkI6YnE4uR./dFIGVkunxwtuLBLBPuNHc0vB.xd9JG', '1234567890'),
('12 Wolf Drive, Houston 77042', 'owner@owner.com','Frank', 'Bustos', 1, '$2a$10$ON6Qi9b5DbfU.VtKtjI6fOjV8e6ZBppAvo2Ha7mfP5drtlI7nx/Xy', '1234567890'),
('12 Wolf Drive, Houston 77042', 'owner2@owner.com','Gonzo', 'Gonzales', 1, '$2a$10$ON6Qi9b5DbfU.VtKtjI6fOjV8e6ZBppAvo2Ha7mfP5drtlI7nx/Xy', '1234567890'),
('12 Wolf Drive, Houston 77042', 'owner3@owner.com','Tristan', 'Crawford', 1, '$2a$10$ON6Qi9b5DbfU.VtKtjI6fOjV8e6ZBppAvo2Ha7mfP5drtlI7nx/Xy', '1234567890'),
('12 Wolf Drive, Houston 77042', 'owner4@owner.com','James', 'Fowler', 1, '$2a$10$ON6Qi9b5DbfU.VtKtjI6fOjV8e6ZBppAvo2Ha7mfP5drtlI7nx/Xy', '1234567890');

INSERT INTO events (
               name, event_budget, location, media_location, description, start_date,
               end_date, target_profit, target_spending, tickets_available,
       tickets_price, url, owner_id
       )

VALUES ('San Antonio Jazz Festival',
       '10000', '300 Navarro Street,San Antonio, Texas', 'https://cdn.filestackcontent.com/N5DCvlDThG20zFzmQb4K',
       'This is a Jazz Festival in downtown San Antonio', '2018-08-17',
       '2018-08-19', '10000', '9000','300','100','http://www.pivycibyv.in', 4
     ),

('The Hip Hop Reunion',
       '30000', '10300 Cypresswood, Houston Texas', 'https://cdn.filestackcontent.com/jbbk6dJIRKqA1nTGLSsp',
       'A once in a lifetime opportunity to enjoy an old school hip hop reunion', '2018-08-24',
       '2018-08-25', '20000', '19000','1300','80','http://www.pivycibyv.in', 5
     ),
('The New York Latin Show',
       '50000', '1335 6th Ave, New York, NY 10019', 'https://cdn.filestackcontent.com/ioaI7G5eTBSgBphoPSbK',
       'A showcase of artists in the middle of New York City', '2018-07-17',
       '2018-07-19', '45000', '39000','1000','90','http://www.pivycibyv.in', 6
     ),
('The Chicago Country Fest',
       '100000', '720 S Michigan Ave, Chicago, IL 60605', 'https://cdn.filestackcontent.com/H7jVCJZT3ywsqq7WRTJA',
       'This is a Jazz Festival in downtown Chicago', '2018-08-17',
       '2018-08-19', '90000', '90000','3000','110','http://www.pivycibyv.in', 7
     ),
('The Seatle Latin Jazz Festival',
       '10000', '701 E Heron St, Aberdeen, WA 98520', 'https://cdn.filestackcontent.com/90sbjlhaQryEb3xq51TA',
       'A Latin Jazz Festival close to the Seatle shore.  It is going to be just amazing!  Buy!', '2018-09-17',
       '2018-09-19', '10000', '9000','300','50','http://www.pivycibyv.in', 4
     ),

('The Los Angeles Disco Festival',
       '10000', '2800 Via Cabrillo-Marina, San Pedro, CA 90731', 'https://cdn.filestackcontent.com/FiCYfcCNT25nADM2scQw',
       'The Los Angeles Disco Festival!  It is going to be just amazing!  Buy!', '2018-09-17',
       '2018-09-19', '10000', '9000','300','90','http://www.pivycibyv.in', 5
     ),

('The DC House Festival',
       '10000', '1919 Connecticut Ave NW, Washington, DC 20009', 'https://cdn.filestackcontent.com/7CrUHQnxQDWq38Qo2URk',
       'The DC House Festival comes back this Summer.  Get your tickets in advance and save... It is going to be just amazing!  Buy!', '2018-06-17',
       '2018-06-19', '10000', '9000','300','100','http://www.pivycibyv.in', 6
     ),

('The Miami Dance Convention',
       '10000', '101 Ocean Dr, Miami Beach, FL 33139', 'https://cdn.filestackcontent.com/21YRfBDnRXSpz8IJvZ8P',
       'The Miami Dance Convention is back with us this Summer.  It is going to be just amazing!  Buy!', '2018-06-28',
       '2018-06-30', '10000', '9000','300','120','http://www.pivycibyv.in', 7
     ),

('The New Orleans Jazz Blowout',
       '10000', '2 Poydras St, New Orleans, LA 70130', 'https://cdn.filestackcontent.com/TMhiL0TRnmjLEViL5zJ6',
       'For the very first time in New Orleans, the JAZZ BLOW OUT!  Get your tickets now! It is going to be just amazing!  Buy!', '2018-09-17',
       '2018-09-19', '10000', '9000','300','80','http://www.pivycibyv.in', 4
     ),

('The Country Festival of Texas',
       '10000', '500 E 4th St, Austin, TX 78701', 'https://cdn.filestackcontent.com/Y6HIxv0ARCW01uqMkFID',
       'The Country of Festival is back this Summer....be there!.  It is going to be just amazing!  Buy!', '2018-07-17',
       '2018-07-19', '10000', '9000','300','80','http://www.pivycibyv.in', 5
     ),

('The New York City DJ Festival',
       '10000', 'Central Park New York City','https://cdn.filestackcontent.com/YiMpr9tsQgKg6SCoxewB',
       'Back in New York City, the NYC DJ Festival is back!  DO IT!.  It is going to be just amazing!  Buy!', '2018-09-17',
       '2018-09-19', '10000', '9000','300','100','http://www.pivycibyv.in', 6
     ),

('The Paris Latin Fiesta',
       '10000', '108 Rue Saint-Lazare, 75008 Paris, France', 'https://cdn.filestackcontent.com/SZp0eV9vRCBmMM09zluZ',
       'Yes, a Fiesta event in the heart of Paris.  This is the second year, and if you were here the first year you know it was a blast.  It is going to be just amazing!  Buy!', '2018-09-17',
       '2018-09-19', '10000', '9000','300','980','http://www.pivycibyv.in', 7
     )
;
