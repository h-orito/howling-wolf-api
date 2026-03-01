-- partition table fk delete

alter table MESSAGE drop foreign key FK_message_village;
alter table MESSAGE drop foreign key FK_message_player;
alter table MESSAGE drop foreign key FK_message_village_day;
alter table MESSAGE drop foreign key FK_message_village_player;
alter table MESSAGE drop foreign key FK_message_village_player_to;
alter table MESSAGE drop foreign key FK_message_message_type;
alter table MESSAGE drop foreign key FK_message_face_type;
alter table MESSAGE_SENDTO drop foreign key FK_MESSAGE_SENDTO_MESSAGE;

-- partition

-- message
alter table MESSAGE partition by hash (village_id) partitions 100;
