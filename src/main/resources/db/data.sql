START TRANSACTION;
-- data for status table
INSERT INTO status (id, name) VALUES
(1, 'COMPLETED'),
(2, 'ONGOING'),
(3, 'ONE SHOT'),
(4, 'HIATUS'),
(5, 'ABANDONED');

-- data for category table
INSERT INTO category(id, name) VALUES
(1, 'ENGLISH NOVEL'),
(2, 'JAPANESE NOVEL');

-- data for author table
INSERT INTO author(id, name) VALUES
(1, 'J.K. ROWLLING'),
(2, 'WATARU WATARI'),
(3, 'DAN BROWN'),
(4, 'YONEZAWA HONOBU'),
(5, 'STAN LEE'),
(6, 'TAKEZUKI JOU');

-- data for book table
INSERT INTO book(id, category_id, author_id, status_id, title, tags) VALUES
(1, 1, 1, 1, 'HARRY POTTER', 'action, fantasy'),
(2, 2, 2, 2, 'OREGAIRU', 'slice of life, comedy'),
(3, 1, 3, 3, 'DARK SIDE', 'horor, mystery'),
(4, 2, 4, 2, 'CLASSIC CLUB SERIES', 'mystery, slice of life'),
(5, 1, 5, 5, 'SPIDER-MAN', 'action, comedy, super hero'),
(6, 2, 6, 4, 'CHRONICLE LEGION', 'action, sci fi');

-- data for series table
INSERT INTO series(id, book_id, saga, title) VALUES
(1, 1, 1, 'SORCERES STONE'),
(2, 1, 2, 'CHAMBER OF SECRET'),
(3, 1, 3, 'PRISONER OF AZKABAN'),
(4, 2, 1, 'VOLUME 1'),
(5, 2, 2, 'VOLUME 2'),
(6, 4, 1, 'HYOUKA'),
(7, 4, 2, 'WHY THEY DID NOT ASK EBA'),
(8, 4, 3, 'ROLE OF THE FOOL'),
(9, 3, 1, 'DARK SIDE OF THE MADMAN');

--user and roles table
INSERT INTO user_account(id, username, email, password, enabled) VALUES
(1, 'admin', 'admin@mail.com', 'x61Ey612Kl2gpFL56FT9weDnpSo4AV8j8+qx2AuTHdRyY036xxzTTrw10Wq3+4qQyB+XURPWx1ON
xp3Y3pB37A==', 1), -- password is admin with SHA-512
(2, 'sukma', 'sukma@mail.com', 'lPzi0dvSiqUEmrwbcFF+E5aRbdQEu5UWzgeiD5a7Vm0NjFmj9Bc4sgEgCTeq1cokWTRk42NfJ+Jl
2ZS5HvOFLw==', 1); --password is sukma with SHA-512

INSERT INTO role(id, role_name) VALUES
(1, 'ADMIN'),
(2, 'LIBRARIAN'),
(3, 'CUSTOMER');

INSERT INTO user_role(user_id, role_id) VALUES
(1, 1),
(2, 3);

COMMIT;