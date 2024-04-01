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
('A', 'B', 1200, 1),
('A', 'C', 1200, 1),
('A', 'D', 1200, 1),
('A', 'E', 1200, 1),
('A', 'B', 1800, 1),
('A', 'C', 1800, 1),
('A', 'D', 1800, 1),
('A', 'E', 1800, 1);

-- Flight from B to other airports
INSERT INTO Flights (departing, destination, departingTime, flightTime) VALUES
('B', 'A', 1200, 1),
('B', 'C', 1200, 1),
('B', 'D', 1200, 1),
('B', 'E', 1200, 1),
('B', 'A', 1800, 1),
('B', 'C', 1800, 1),
('B', 'D', 1800, 1),
('B', 'E', 1800, 1);

-- Flight from C to other airports
INSERT INTO Flights (departing, destination, departingTime, flightTime) VALUES
('C', 'A', 1200, 1),
('C', 'B', 1200, 1),
('C', 'D', 1200, 1),
('C', 'E', 1200, 1),
('C', 'A', 1800, 1),
('C', 'B', 1800, 1),
('C', 'D', 1800, 1),
('C', 'E', 1800, 1);

-- Flight from D to other airports
INSERT INTO Flights (departing, destination, departingTime, flightTime) VALUES
('D', 'A', 1200, 1),
('D', 'B', 1200, 1),
('D', 'C', 1200, 1),
('D', 'E', 1200, 1);
('D', 'A', 1800, 1),
('D', 'B', 1800, 1),
('D', 'C', 1800, 1),
('D', 'E', 1800, 1);

-- Flight from E to other airports
INSERT INTO Flights (departing, destination, departingTime, flightTime) VALUES
('E', 'A', 1200, 1),
('E', 'B', 1200, 1),
('E', 'C', 1200, 1),
('E', 'D', 1200, 1),
('E', 'A', 1800, 1),
('E', 'B', 1800, 1),
('E', 'C', 1800, 1),
('E', 'D', 1800, 1);


