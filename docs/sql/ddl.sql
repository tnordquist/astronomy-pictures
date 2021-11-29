CREATE TABLE IF NOT EXISTS `user`
(
    `user_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`      TEXT                              NOT NULL,
    `email`     TEXT                              NOT NULL,
    `created`   INTEGER                           NOT NULL,
    `oauth_key` TEXT                              NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_user_oauth_key` ON `user` (`oauth_key`);

CREATE TABLE IF NOT EXISTS `image`
(
    `image_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `created`     INTEGER                           NOT NULL,
    `date`        INTEGER                           NOT NULL,
    `title`       TEXT                              NOT NULL,
    `description` TEXT,
    `media_type`  TEXT                              NOT NULL,
    `url`         TEXT                              NOT NULL,
    `hdUrl`       TEXT,
    `path`        TEXT
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_image_date` ON `image` (`date`);

CREATE INDEX IF NOT EXISTS `index_image_media_type` ON `image` (`media_type`);

CREATE TABLE IF NOT EXISTS `favorite`
(
    `favorite_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `created`     INTEGER                           NOT NULL,
    `user_id`     INTEGER                           NOT NULL,
    `image_id`    INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_favorite_user_id` ON `favorite` (`user_id`);

CREATE INDEX IF NOT EXISTS `index_favorite_image_id` ON `favorite` (`image_id`);

