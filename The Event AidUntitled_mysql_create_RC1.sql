CREATE TABLE `users` (
	`id` int NOT NULL AUTO_INCREMENT,
	`firstname` char(255) NOT NULL,
	`lastname` char(255) NOT NULL,
	`address` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`telephone` varchar(255) NOT NULL,
	`created_on` TIMESTAMP NOT NULL,
	`owner` bool NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `events` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
	`start_date` DATE NOT NULL,
	`end_date` DATE NOT NULL,
	`location` varchar(255) NOT NULL,
	`url` varchar(255) NOT NULL,
	`venue_id` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `budgets` (
	`id` int NOT NULL AUTO_INCREMENT,
	`event_budget` DECIMAL(13,2) NOT NULL,
	`target_spending` DECIMAL(13,2) NOT NULL,
	`target_profit` DECIMAL(13,2) NOT NULL,
	`event_id` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `artists` (
	`id` int NOT NULL,
	`firstname` char(255) NOT NULL,
	`lastname` char(255) NOT NULL,
	`cost` DECIMAL(6,2) NOT NULL,
	`contract` bool NOT NULL,
	`contract_location` char(255) NOT NULL,
	`notes` varchar(255),
	PRIMARY KEY (`id`)
);

CREATE TABLE `transportation` (
	`id` int NOT NULL AUTO_INCREMENT,
	`artist_id` int NOT NULL,
	`pickup` DATETIME NOT NULL,
	`dropoff` DATETIME NOT NULL,
	`uber_code` varchar(255) NOT NULL,
	`uber_cost` DECIMAL(5,2) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `venues` (
	`id` int NOT NULL AUTO_INCREMENT,
	`cost` DECIMAL(13,2) NOT NULL,
	`address` varchar(255) NOT NULL,
	`contract` bool NOT NULL,
	`contract_location` char(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `event_tickets` (
	`id` int NOT NULL AUTO_INCREMENT,
	`user_id` int NOT NULL,
	`price` DECIMAL(5,2) NOT NULL,
	`purchased_on` TIMESTAMP NOT NULL,
	`event_id` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `schedules` (
	`id` int NOT NULL AUTO_INCREMENT,
	`event_id` int NOT NULL,
	`start_time` TIME NOT NULL,
	`end_time` TIME NOT NULL,
	`subject` char(100) NOT NULL,
	`location` char(255) NOT NULL,
	`artist_id` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `users_events` (
	`user_id` int NOT NULL,
	`events_id` int NOT NULL
);

ALTER TABLE `events` ADD CONSTRAINT `events_fk0` FOREIGN KEY (`venue_id`) REFERENCES `venues`(`id`);

ALTER TABLE `budgets` ADD CONSTRAINT `budgets_fk0` FOREIGN KEY (`event_id`) REFERENCES `events`(`id`);

ALTER TABLE `transportation` ADD CONSTRAINT `transportation_fk0` FOREIGN KEY (`artist_id`) REFERENCES `artists`(`id`);

ALTER TABLE `event_tickets` ADD CONSTRAINT `event_tickets_fk0` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `event_tickets` ADD CONSTRAINT `event_tickets_fk1` FOREIGN KEY (`event_id`) REFERENCES `events`(`id`);

ALTER TABLE `schedules` ADD CONSTRAINT `schedules_fk0` FOREIGN KEY (`event_id`) REFERENCES `events`(`id`);

ALTER TABLE `schedules` ADD CONSTRAINT `schedules_fk1` FOREIGN KEY (`artist_id`) REFERENCES `artists`(`id`);

ALTER TABLE `users_events` ADD CONSTRAINT `users_events_fk0` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `users_events` ADD CONSTRAINT `users_events_fk1` FOREIGN KEY (`events_id`) REFERENCES `events`(`id`);

