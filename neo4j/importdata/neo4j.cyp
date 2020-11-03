CREATE (admin:Role {name: 'admin'});

CREATE (user:Role {name: 'user'});

CREATE (just_support:ProjectType {name: 'just_support'});

CREATE (kickstarter:ProjectType {name: 'kickstarter'});

CREATE (four_d_chess_1:Project {
  name:        'Board game',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 11}),
  imagesUrls:  ['https://pbs.twimg.com/media/ESNpMg_WoAAy8FV.jpg'],
  overallBack: 5456.43,
  currentBack: 2332.67
});

CREATE (four_d_chess_2:Project {
  name:        'Board game',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 11}),
  imagesUrls:  ['https://pbs.twimg.com/media/ESNpMg_WoAAy8FV.jpg'],
  overallBack: 5456.43,
  currentBack: 2332.67
});

CREATE (four_d_chess_3:Project {
  name:        'Board game',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 11}),
  imagesUrls:  ['https://pbs.twimg.com/media/ESNpMg_WoAAy8FV.jpg'],
  overallBack: 5456.43,
  currentBack: 2332.67
});

CREATE (art_1:Project {
  name:        'Paint',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 8, day: 11}),
  imagesUrls:  [
                 'https://images.wallpaperscraft.ru/image/vinsent_van_gog_zvezdnaya_noch_maslo_kholst_117815_1920x1080.jpg'],
  overallBack: 3456.43,
  currentBack: 22.67
});

CREATE (denis:User {
  id:        '1',
  username:  'Denis',
  login:     'denis2000',
  fullName:  'Denis Borschevsky',
  createdAt: date(),
  birthday:  date({year: 2000, month: 2, day: 16})
});

CREATE (oleg:User {
  id:        '2',
  username:  'Oleg',
  login:     'oleg2000',
  fullName:  'Oleg Vinograd',
  createdAt: date(),
  birthday:  date({year: 2000, month: 1, day: 9})
})
CREATE (vlad:User {
  id:        '3',
  username:  'Vlad',
  login:     'vladNaChille',
  fullName:  'Vlad Rogovsky',
  createdAt: date(),
  birthday:  date({year: 1999, month: 9, day: 23})
})

CREATE (p_1:Payment {
  amount:    543.32,
  createdAt: date()
})

CREATE (p_2:Payment {
  amount:    434.32,
  createdAt: date()
})

CREATE (faq_1:Faq {
  question: 'How is it work?',
  answer:   'Magic'
})
CREATE (faq_2:Faq {
  question: 'Do we support shipment in Belarus?',
  answer:   'No, only USA'
})
CREATE (faq_3:Faq {
  question: 'Do we support shipment in Belarus?',
  answer:   'Yes, but with tax'
})

CREATE (comment_1:Comment {
  createdAt: date(),
  message:   'I got strange box with trash..'
})
CREATE (comment_2:Comment {
  createdAt: date(),
  message:   'I like this!!'
})
CREATE (comment_3:Comment {
  createdAt: date(),
  message:   'Good luuck. I wish you achive all goals.'
})

CREATE (board_game:Category {
  category: 'Board games'
})
CREATE (art:Category {
  category: 'Arts'
})

CREATE (back_option_1:BackOption {
  pledge: 5,
  reward: 'Stikers'
})
CREATE (back_option_2:BackOption {
  pledge: 10,
  reward: 'Badges'
})
CREATE (back_option_3:BackOption {
  pledge: 35,
  reward: 'T-shorts'
})
CREATE (back_option_4:BackOption {
  pledge: 100,
  reward: 'Subscribtion for 24 month'
})

CREATE
  (denis)-[:HAS]->(admin),
  (oleg)-[:HAS]->(admin),
  (vlad)-[:HAS]->(user),

@TODO complete this shit please thank you





