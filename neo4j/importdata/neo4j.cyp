CREATE (admin:Role {name: 'admin'})

CREATE (user:Role {name: 'user'})

CREATE (just_support:ProjectType {name: 'just_support'})

CREATE (kickstarter:ProjectType {name: 'kickstarter'})

CREATE (four_d_chess_1:Project {
  id:          '1',
  name:        'Board game',
  description: 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32. The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 11}),
  imageUrls:   ['https://pbs.twimg.com/media/ESNpMg_WoAAy8FV.jpg'],
  overallBack: '5456.43',
  currentBack: '2332.67'
})

CREATE (four_d_chess_2:Project {
  id:          '2',
  name:        'Board game',
  description: 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32. The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 11}),
  imageUrls:   ['https://pbs.twimg.com/media/ESNpMg_WoAAy8FV.jpg'],
  overallBack: '5456.43',
  currentBack: '2332.67'
})

CREATE (four_d_chess_3:Project {
  id:          '3',
  name:        'Board game',
  description: 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32. The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 11}),
  imageUrls:   ['https://pbs.twimg.com/media/ESNpMg_WoAAy8FV.jpg'],
  overallBack: '5456.43',
  currentBack: '2332.67'
})

CREATE (art_1:Project {
  id:          '4',
  name:        'Paint',
  description: 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32. The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 8, day: 11}),
  imageUrls:   [
                 'https://images.wallpaperscraft.ru/image/vinsent_van_gog_zvezdnaya_noch_maslo_kholst_117815_1920x1080.jpg'],
  overallBack: '3456.43',
  currentBack: '22.67'
})

CREATE (denis:User {
  id:        '1',
  username:  'denis2000',
  password:  'denis2000',
  fullName:  'Denis Borschevsky',
  createdAt: date(),
  birthday:  date({year: 2000, month: 2, day: 16}),
  avatar:    'https://i.imgur.com/rBQq49N.png'
})

CREATE (oleg:User {
  id:        '2',
  username:  'oleg2000',
  password:  'oleg2000',
  fullName:  'Oleg Vinograd',
  createdAt: date(),
  birthday:  date({year: 2000, month: 1, day: 9}),
  avatar:    'https://i.pinimg.com/236x/1e/aa/75/1eaa75496c78dc65c9c7358cd8dd759a.jpg'
})
CREATE (vlad:User {
  id:        '3',
  username:  'vladNaChille',
  password:  'vladNaChille',
  fullName:  'Vlad Rogovsky',
  createdAt: date(),
  birthday:  date({year: 1999, month: 9, day: 23}),
  avatar:    'https://steamrep.com/steamimage/avatars/f4/f4027e888be814ae0d933b2e13de7a8ac098713a_full.jpg'
})

CREATE (p_1:Payment {
  amount:    '543.32',
  createdAt: date()
})

CREATE (p_2:Payment {
  amount:    '434.32',
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
  name: 'Board games'
})
CREATE (art:Category {
  name: 'Arts'
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

  (denis)-[:LIKES]->(oleg),
  (oleg)-[:LIKES]->(denis),
  (vlad)-[:LIKES]->(oleg),
  (vlad)-[:LIKES]->(denis),

  (denis)-[:FOLLOWS]->(oleg),
  (oleg)-[:FOLLOWS]->(denis),
  (vlad)-[:FOLLOWS]->(oleg),
  (vlad)-[:FOLLOWS]->(denis),
  (oleg)-[:FOLLOWS]->(vlad),

  (denis)-[:OWNS]->(four_d_chess_1),
  (denis)-[:OWNS]->(four_d_chess_2),
  (oleg)-[:OWNS]->(four_d_chess_3),
  (vlad)-[:OWNS]->(art_1),

  (denis)-[:CREATES]->(comment_1),
  (oleg)-[:CREATES]->(comment_2),
  (vlad)-[:CREATES]->(comment_3),

  (vlad)-[:MAKES]->(p_1),
  (oleg)-[:MAKES]->(p_2),

  (four_d_chess_1)-[:HAS]->(comment_1),
  (four_d_chess_2)-[:HAS]->(comment_2),
  (four_d_chess_2)-[:HAS]->(comment_3),

  (four_d_chess_1)-[:IS]->(kickstarter),
  (four_d_chess_2)-[:IS]->(kickstarter),
  (four_d_chess_3)-[:IS]->(kickstarter),
  (art_1)-[:IS]->(just_support),

  (four_d_chess_1)-[:HAS]->(faq_1),
  (four_d_chess_2)-[:HAS]->(faq_2),
  (four_d_chess_2)-[:HAS]->(faq_3),
  (four_d_chess_3)-[:HAS]->(faq_3),

  (four_d_chess_1)-[:HAS]->(back_option_1),
  (four_d_chess_1)-[:HAS]->(back_option_2),
  (four_d_chess_2)-[:HAS]->(back_option_3),
  (four_d_chess_3)-[:HAS]->(back_option_4),

  (four_d_chess_1)-[:RELATED_TO]->(board_game),
  (four_d_chess_2)-[:RELATED_TO]->(board_game),
  (four_d_chess_3)-[:RELATED_TO]->(board_game),
  (art_1)-[:RELATED_TO]->(art),

  (four_d_chess_1)<-[:LIKES]-(denis),
  (four_d_chess_2)<-[:LIKES]-(denis),
  (four_d_chess_3)<-[:LIKES]-(denis),
  (four_d_chess_2)<-[:LIKES]-(oleg),
  (art_1)<-[:LIKES]-(oleg),
  (four_d_chess_3)<-[:LIKES]-(vlad),
  (art_1)<-[:LIKES]-(denis),

  (four_d_chess_1)<-[:PASSED_TO]-(p_2),
  (four_d_chess_2)<-[:PASSED_TO]-(p_1),

  (back_option_3)<-[:WANTS]-(vlad),

  (back_option_3)<-[:WANTS]-(p_1)
