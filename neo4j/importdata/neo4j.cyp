CREATE (admin:Role {
  id:   '1',
  name: 'admin'
})

CREATE (user:Role {
  id:   '2',
  name: 'user'
})

CREATE (just_support:ProjectType {
  id:   '1',
  name: 'just_support'
})

CREATE (kickstarter:ProjectType {
  id:   '2',
  name: 'kickstarter'
})

CREATE (four_d_chess_1:Project {
  id:          '1',
  name:        '4D Шахматы',
  description: 'Четверные немецкие шахматы, европейские четверные шахматы или шахматы вчетвером — вариант шахмат, который допускает игру между четырьмя участниками. Игра проводится на особой доске, которая представляет собой классическую шахматную доску с тремя дополнительными рядами по восемь клеток с каждой стороны. Для игры необходимы 4 комплекта разноцветных фигур.',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 11}),
  imageUrls:   ['https://pbs.twimg.com/media/ESNpMg_WoAAy8FV.jpg'],
  overallBack: '5456.43',
  currentBack: '2332.67'
})

CREATE (card_game:Project {
  id:          '2',
  name:        'Уно',
  description: 'У́но (Uno, с исп. — «Uno», один). Игра первоначально была разработана в 1971 году парикмахером Мерлом Роббинсом в городке Реддинг, в пригороде Цинциннати, штат Огайо, США. В 1992 году компания Mattel выкупила права на игру и бренд. Игра Uno в значительной степени совпадает с популярной европейской игрой мау-мау, известной в России как «Сто одно», но требует специальной колоды карт. Время игры от 15 минут. Минимум 2 игрока.',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 11}),
  imageUrls:   ['https://image.api.playstation.com/cdn/EP0001/CUSA04040_00/LRI3Rg5MKOi5AkefFaMcChNv5WitM7sz.png'],
  overallBack: '5456.43',
  currentBack: '1400.67'
})

CREATE (lego:Project {
  id:          '3',
  name:        'Лего Minecraft',
  description: 'Конструктор Лего – признанная во всем мире не только самая желанная, но и самая полезная игра. Она позволяет научиться следовать инструкции, создавать декорации и персонажей для ролевых игр. Купить Lego можно в подарок своему ребенку или чаду друзей, просто для расширения игровых возможностей. В любом случае можете быть уверены, что сюрприз будет кстати.',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 11}),
  imageUrls:   ['https://www.funtastik.by/upload/iblock/df5/df5a07e97d89694b3e119dc06306290f.jpg'],
  overallBack: '7894.43',
  currentBack: '4555.67'
})

CREATE (art_1:Project {
  id:          '4',
  name:        'Картина Анонимного Автора',
  description: 'Здравствуйте, я начинающий художник, мне очень нравится заниматься этой деятельностью. Был бы признательным, получить минимальное спонсирование для продолжение деятельности, Спасибо',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 8, day: 11}),
  imageUrls:   [
                 'https://images.wallpaperscraft.ru/image/vinsent_van_gog_zvezdnaya_noch_maslo_kholst_117815_1920x1080.jpg'],
  overallBack: '3456.43',
  currentBack: '658.67'
})

CREATE (denis:User {
  id:        '1',
  username:  'denis2000',
  password:  'denis2000',
  fullName:  'Денис Борщевский',
  createdAt: date(),
  birthday:  date({year: 2000, month: 2, day: 16}),
  avatar:    'https://i.imgur.com/rBQq49N.png'
})

CREATE (oleg:User {
  id:        '2',
  username:  'oleg2000',
  password:  'oleg2000',
  fullName:  'Олег Виноград',
  createdAt: date(),
  birthday:  date({year: 2000, month: 1, day: 9}),
  avatar:    'https://i.pinimg.com/236x/1e/aa/75/1eaa75496c78dc65c9c7358cd8dd759a.jpg'
})
CREATE (vlad:User {
  id:        '3',
  username:  'vladNaChille',
  password:  'vladNaChille',
  fullName:  'Влад Роговский',
  createdAt: date(),
  birthday:  date({year: 1999, month: 9, day: 23}),
  avatar:    'https://steamrep.com/steamimage/avatars/f4/f4027e888be814ae0d933b2e13de7a8ac098713a_full.jpg'
})

CREATE (p_1:Payment {
  id:        '1',
  amount:    '543.32',
  createdAt: localdatetime()
})

CREATE (p_2:Payment {
  id:        '2',
  amount:    '434.32',
  createdAt: localdatetime()
})

CREATE (faq_1:Faq {
  id:       '1',
  question: 'Как это работает?',
  answer:   'Магия'
})
CREATE (faq_2:Faq {
  id:       '2',
  question: 'Вы поддерживаете доставку в Беларусь?',
  answer:   'Нет, только США'
})
CREATE (faq_3:Faq {
  id:       '3',
  question: 'Вы поодерживаете доставку в Беларусь?',
  answer:   'Да, но с дополнительной платой'
})

CREATE (comment_1:Comment {
  id:        '1',
  createdAt: localdatetime(),
  message:   'Я получил странную коробку с мусором...'
})
CREATE (comment_2:Comment {
  id:        '2',
  createdAt: localdatetime(),
  message:   'Обожаю это!!'
})
CREATE (comment_3:Comment {
  id:        '3',
  createdAt: localdatetime(),
  message:   'Удачи, желаю успехов в достижении цени!'
})

CREATE (board_game:Category {
  id:   '1',
  name: 'Настольные игры'
})
CREATE (art:Category {
  id:   '2',
  name: 'Искусство'
})

CREATE (back_option_1:BackOption {
  id:     '1',
  pledge: 5,
  reward: 'Стикеры'
})
CREATE (back_option_2:BackOption {
  id:     '2',
  pledge: 10,
  reward: 'Значки'
})
CREATE (back_option_3:BackOption {
  id:     '3',
  pledge: 35,
  reward: 'Майки'
})
CREATE (back_option_4:BackOption {
  id:     '4',
  pledge: 100,
  reward: 'Подписка на 24 месяца'
})

CREATE
  (denis)-[:HAS]->(user),
  (oleg)-[:HAS]->(admin),
  (vlad)-[:HAS]->(user),

  (denis)-[:FOLLOWS]->(oleg),
  (oleg)-[:FOLLOWS]->(denis),
  (vlad)-[:FOLLOWS]->(oleg),
  (vlad)-[:FOLLOWS]->(denis),
  (oleg)-[:FOLLOWS]->(vlad),

  (denis)-[:OWNS]->(four_d_chess_1),
  (denis)-[:OWNS]->(card_game),
  (oleg)-[:OWNS]->(lego),
  (vlad)-[:OWNS]->(art_1),

  (denis)-[:CREATES]->(comment_1),
  (oleg)-[:CREATES]->(comment_2),
  (vlad)-[:CREATES]->(comment_3),

  (vlad)-[:MAKES]->(p_1),
  (oleg)-[:MAKES]->(p_2),

  (four_d_chess_1)-[:HAS]->(comment_1),
  (card_game)-[:HAS]->(comment_2),
  (card_game)-[:HAS]->(comment_3),

  (four_d_chess_1)-[:IS]->(kickstarter),
  (card_game)-[:IS]->(kickstarter),
  (lego)-[:IS]->(kickstarter),
  (art_1)-[:IS]->(just_support),

  (four_d_chess_1)-[:HAS]->(faq_1),
  (card_game)-[:HAS]->(faq_2),
  (card_game)-[:HAS]->(faq_3),
  (lego)-[:HAS]->(faq_3),

  (four_d_chess_1)-[:HAS]->(back_option_1),
  (four_d_chess_1)-[:HAS]->(back_option_2),
  (card_game)-[:HAS]->(back_option_3),
  (lego)-[:HAS]->(back_option_4),

  (four_d_chess_1)-[:RELATED_TO]->(board_game),
  (card_game)-[:RELATED_TO]->(board_game),
  (lego)-[:RELATED_TO]->(board_game),
  (art_1)-[:RELATED_TO]->(art),

  (four_d_chess_1)<-[:LIKES]-(denis),
  (card_game)<-[:LIKES]-(denis),
  (lego)<-[:LIKES]-(denis),
  (card_game)<-[:LIKES]-(oleg),
  (art_1)<-[:LIKES]-(oleg),
  (lego)<-[:LIKES]-(vlad),
  (art_1)<-[:LIKES]-(denis),

  (four_d_chess_1)<-[:PASSED_TO]-(p_2),
  (card_game)<-[:PASSED_TO]-(p_1),

  (back_option_3)<-[:WANTS]-(vlad),

  (back_option_3)<-[:WANTS]-(p_1)
