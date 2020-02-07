DROP TABLE IF EXISTS emails;

CREATE TABLE emails (
    id VARCHAR(40) PRIMARY KEY,
    sender VARCHAR(128) NOT NULL,
    receiver VARCHAR(128) NOT NULL,
    subject VARCHAR(128) NOT NULL,
    body VARCHAR(1024) NOT NULL,
    meta VARCHAR(1024) NOT NULL,
    date DATETIME NOT NULL
);

INSERT INTO emails (id, sender, receiver, subject, body, meta, date) VALUES
('1', 'nigerian_prince@hotmale.com', 'jonnie85@gmail.com', 'Free money my friend', 'Hi I offer you free money', 'meta meta meta meta META', '2018-06-19 10:34:09');