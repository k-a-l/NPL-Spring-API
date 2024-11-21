INSERT INTO team (name, ownership_name, city)
VALUES
    ('Kathmandu Gurkhas', 'Gurkhas Holdings', 'Kathmandu'),
    ('Pokhara Warriors', 'Pokhara Premier League Pvt Ltd', 'Pokhara');

INSERT INTO player (name, age, team_id, price, role, nationality, marquee, foreign_player)
VALUES
    ('Karan KC', 33, 1, 20.0, 'All-rounder', 'Nepal', true, false),  -- team_id = 1 (Kathmandu Gurkhas)
    ('Paras Khadka', 36, 1, 25.0, 'Batsman', 'Nepal', true, false),  -- team_id = 1 (Kathmandu Gurkhas)
    ('Sandeep Lamichhane', 23, 1, 30.0, 'Bowler', 'Nepal', true, false),  -- team_id = 1 (Kathmandu Gurkhas)
    ('Rohit Sharma', 35, 2, 50.0, 'Batsman', 'India', false, true),  -- team_id = 2 (Pokhara Warriors)
    ('Trent Boult', 34, 2, 60.0, 'Bowler', 'New Zealand', false, true),  -- team_id = 2 (Pokhara Warriors)
    ('Aarif Sheikh', 28, 2, 15.0, 'All-rounder', 'Nepal', false, false),  -- team_id = 2 (Pokhara Warriors)
    ('Dipendra Singh Airee', 24, 1, 18.0, 'All-rounder', 'Nepal', false, false),  -- team_id = 1 (Kathmandu Gurkhas)
    ('Rashid Khan', 25, 2, 70.0, 'Bowler', 'Afghanistan', false, true);  -- team_id = 2 (Pokhara Warriors)

