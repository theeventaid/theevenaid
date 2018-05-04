USE tea_db;

INSERT INTO venues (address, contract, contract_location, costs) VALUES ('240 Patton Ave', 1, '240 Patton Ave', 5000);
INSERT INTO events (end_date, location, name, start_date, url, venue_id) VALUES (CURRENT_DATE, 'Party House', 'Basement Show', CURRENT_DATE, 'stuffandthings.com', 1);
INSERT INTO events (end_date, location, name, start_date, url, venue_id) VALUES (CURRENT_DATE, 'Party House', 'LAN Party', CURRENT_DATE, 'cheeseanddoritos.com', 1);
INSERT INTO events (end_date, location, name, start_date, url, venue_id) VALUES (CURRENT_DATE, 'Party House', 'Deadmau5', CURRENT_DATE, 'dubstepisdead.com', 1);
