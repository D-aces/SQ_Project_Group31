use quality_project;
-- Populate the Airports table
INSERT INTO Airports (port_name, connecting) VALUES
('A', 'B:C:D:E'),
('B', 'A:C:D:E'),
('C', 'A:B:D:E'),
('D', 'A:B:C:E'),
('E', 'A:B:C:D');

-- Populate the Flights table
-- Flight from A to other airports
INSERT INTO Flights (departing, destination, departingTime, flightTime) VALUES
('A', 'B', 21600, 1),
('A', 'C', 21600, 1),
('A', 'D', 21600, 1),
('A', 'E', 21600, 2),
('A', 'B', 43200, 1),
('A', 'C', 43200, 1),
('A', 'D', 43200, 1),
('A', 'E', 43200, 2),
('A', 'B', 64800, 1),
('A', 'C', 64800, 1),
('A', 'D', 64800, 1),
('A', 'E', 64800, 2);

-- Flight from B to other airports
INSERT INTO Flights (departing, destination, departingTime, flightTime) VALUES
('B', 'A', 21600, 1),
('B', 'C', 21600, 1),
('B', 'D', 21600, 2),
('B', 'E', 21600, 1),
('B', 'A', 43200, 1),
('B', 'C', 43200, 1),
('B', 'D', 43200, 2),
('B', 'E', 43200, 1),
('B', 'A', 64800, 1),
('B', 'C', 64800, 1),
('B', 'D', 64800, 2),
('B', 'E', 64800, 1);

-- Flight from C to other airports
INSERT INTO Flights (departing, destination, departingTime, flightTime) VALUES
('C', 'A', 21600, 1),
('C', 'B', 21600, 1),
('C', 'D', 21600, 1),
('C', 'E', 21600, 1),
('C', 'A', 43200, 1),
('C', 'B', 43200, 1),
('C', 'D', 43200, 1),
('C', 'E', 43200, 1),
('C', 'A', 64800, 1),
('C', 'B', 64800, 1),
('C', 'D', 64800, 1),
('C', 'E', 64800, 1);

-- Flight from D to other airports
INSERT INTO Flights (departing, destination, departingTime, flightTime) VALUES
('D', 'A', 21600, 1),
('D', 'B', 21600, 2),
('D', 'C', 21600, 1),
('D', 'E', 21600, 1),
('D', 'A', 43200, 1),
('D', 'B', 43200, 2),
('D', 'C', 43200, 1),
('D', 'E', 43200, 1),
('D', 'A', 64800, 1),
('D', 'B', 64800, 2),
('D', 'C', 64800, 1),
('D', 'E', 64800, 1);

-- Flight from E to other airports
INSERT INTO Flights (departing, destination, departingTime, flightTime) VALUES
('E', 'A', 21600, 2),
('E', 'B', 21600, 1),
('E', 'C', 21600, 1),
('E', 'D', 21600, 1),
('E', 'A', 43200, 2),
('E', 'B', 43200, 1),
('E', 'C', 43200, 1),
('E', 'D', 43200, 1),
('E', 'A', 64800, 2),
('E', 'B', 64800, 1),
('E', 'C', 64800, 1),
('E', 'D', 64800, 1);


