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

CREATE (oven_steel:Project {
  id:          '1',
  name:        'The Misen Oven Steel',
  description: 'Precise cooking & better browning, for a lifetime.',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 14}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/545/919/de459243f5ecab0b98e8dcf4f3bf7173_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1621281827&auto=format&frame=1&lossless=true&s=e7fd2090ed199b493541b4d932aaa57a',
                 'https://ksr-ugc.imgix.net/assets/033/664/492/5297a97a320caf2ddad0f74576fd4753_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1622056286&auto=format&frame=1&lossless=true&s=76da508f756f69526802a9244890b249',
                 'https://ksr-ugc.imgix.net/assets/033/664/378/85b40cca1ac61466607e22c30c83b33b_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1622055685&auto=format&frame=1&lossless=true&s=d460211b94c6324ffd64cbadf660003c'],
  overallBack: '25000',
  currentBack: '21349'
})
CREATE (pico_max:Project {
  id:          '2',
  name:        'Pico Max: Grow a Garden Anywhere!',
  description: 'Grow thriving plants everywhere with a click - telescopic LED lights, multiple mounts, and a self-watering system. Anyone can do it!',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 8, day: 23}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/831/505/95d94f39c94cf065649dfa07f73034eb_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1623255511&auto=format&frame=1&lossless=true&s=1eeb1cd854e8c65aeb95047ba83cff3c',
                 'https://ksr-ugc.imgix.net/assets/033/841/135/44772e909eb91c9d83cca6daf287bd7e_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1623323264&auto=format&frame=1&lossless=true&s=eaa0603550d07d7fd989c97f52d64742',
                 'https://ksr-ugc.imgix.net/assets/033/841/139/6d9558328420ca6bb392b269f504c6df_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1623323297&auto=format&frame=1&lossless=true&s=3d4e5c2064fbe4b63391d99985a5efa8'],
  overallBack: '30000',
  currentBack: '14213'
})
CREATE (dedfish:Project {
  id:          '3',
  name:        'Dedfish Co. Portable Kitchen Knife Set',
  description: 'This Portable Knife Set Makes Cutting, Chopping, & Storing Hassle-Free.',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 7, day: 21}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/634/168/1ef090ded184c7a45eb7f33d0d263273_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1621871812&auto=format&frame=1&lossless=true&s=c10bb1926d6d3d396c6ea50847a8cbd5',
                 'https://ksr-ugc.imgix.net/assets/033/633/935/08c68c9c153092502f84cefea9f1cf70_original.gif?ixlib=rb-4.0.2&w=680&fit=max&v=1621870594&auto=format&gif-q=50&q=92&s=2b2ee5fd76a746f661cf9cb791517132'],
  overallBack: '10000',
  currentBack: '4555'
})
CREATE (hannibal:Project {
  id:          '4',
  name:        'Hannibal & Will inspired golden hard enamel pins - Fannibal',
  description: '2 golden hard enamel pins with stained glass effect backgrounds',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 12, day: 11}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/552/965/ee79416bf353f277e9ab88ed94d7135e_original.png?ixlib=rb-4.0.2&crop=faces&w=1024&h=576&fit=crop&v=1621327519&auto=format&frame=1&q=92&s=2f96e6a859bc7e5df9c0fada73752814'],
  overallBack: '3000',
  currentBack: '658'
})
CREATE (cubes:Project {
  id:          '5',
  name:        'Assembly Cubes – Build anything with connectable blocks.',
  description: 'Build anything in blocks; 3D-printed interlocking cubes. Slide into place to connect, rotate to change orientation, and assemble away.',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 9, day: 15}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/792/951/db79785d2d8f5c91f8bcee0470a1728d_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1623005958&auto=format&frame=1&lossless=true&s=5efbfa806fc7ce042f1b1ab8d1ff87db',
                 'https://ksr-ugc.imgix.net/assets/033/792/875/d8fa20e031ae30b9fbf538b569345f57_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1623005553&auto=format&frame=1&lossless=true&s=c16144b8d5f1a1171b49b92b382ff85e'],
  overallBack: '5000',
  currentBack: '4600'
})
CREATE (wanderlost:Project {
  id:          '6',
  name:        'Wanderlost',
  description: 'Wholesome meets post-apocalyptic: A survival crafting RPG with deep systems, engaging real-time gameplay and adorable characters',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 11}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/618/478/92de51cb78d23cd549fef6f0e3eec8bb_original.gif?ixlib=rb-4.0.2&w=680&fit=max&v=1621730044&auto=format&gif-q=50&q=92&s=0bb5d77ee8b969c8c3fdfed9bd81223e',
                 'https://ksr-ugc.imgix.net/assets/033/607/825/b6bef381f5389bc103791bdb1569540f_original.gif?ixlib=rb-4.0.2&w=680&fit=max&v=1621636061&auto=format&gif-q=50&q=92&s=da5d910a7135a670a45e991e15218acd'],
  overallBack: '40000',
  currentBack: '23490'
})
CREATE (heroes:Project {
  id:          '7',
  name:        'Heroes of Barcadia',
  description: 'A pun-tastic, tile-based, dungeon-crawling, party tabletop game with a liquid twist — your health is measured by your drink!',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 11, day: 14}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/781/088/4ab1945031ee3e5616d0eba0d08b6cf6_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1622881472&auto=format&frame=1&lossless=true&s=1e17a8622086fdb4e06338f8ddd98a55'],
  overallBack: '50000',
  currentBack: '48912'
})
CREATE (orbidice:Project {
  id:          '8',
  name:        'Orbidice - The First Spherical RPG Full Dice Set',
  description: 'Unique and customizable dice that will take your game to epic levels',
  createdAt:   date(),
  deadline:    date({year: 2022, month: 2, day: 3}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/450/189/c50449100c4069671a5b3e12802c6074_original.gif?ixlib=rb-4.0.2&w=680&fit=max&v=1620591803&auto=format&gif-q=50&q=92&s=4d1499c56f334489152c8cb71b2cf24d'],
  overallBack: '18000',
  currentBack: '5233'
})
CREATE (mountain:Project {
  id:          '9',
  name:        'Fall of the Mountain King',
  description: 'A 1-5 player standalone prequel to the award winning In the Hall of The Mountain King.',
  createdAt:   date(),
  deadline:    date({year: 2022, month: 1, day: 11}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/691/918/bbbe08ab8fdb935299fcd034f76599b0_original.gif?ixlib=rb-4.0.2&w=680&fit=max&v=1622238629&auto=format&gif-q=50&q=92&s=1f16c4e9bf042dd04d29b1f3ea979f53'],
  overallBack: '55000',
  currentBack: '52330'
})
CREATE (sagas:Project {
  id:          '10',
  name:        'Sagas of the Shield Maiden Book Two (+ Book One)',
  description: 'Book Two of the Viking Western comic - Recounting the legends of The Shield Maiden as she traverses Scandinavia & beyond the North Sea.',
  createdAt:   date(),
  deadline:    date({year: 2022, month: 3, day: 23}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/360/417/4aea8bce393cb987c580b0cc0f9b1660_original.jpg?ixlib=rb-4.0.2&w=680&fit=max&v=1619962839&auto=format&frame=1&q=92&s=6be316d690cc06e4a64c9b8c3d11955d',
                 'https://ksr-ugc.imgix.net/assets/033/447/228/ed0294eb2fdbf109d2f6ecd8f41e6405_original.jpg?ixlib=rb-4.0.2&w=680&fit=max&v=1620568316&auto=format&frame=1&q=92&s=aecc1eab17bf6aaeed2ea54297c0c82d'],
  overallBack: '7000',
  currentBack: '6100'
})
CREATE (wayfinders:Project {
  id:          '11',
  name:        'Wayfinders: Off Course',
  description: 'Printed Book 1 of the webcomic "Wayfinders: Off Course" - a DnD-based fantasy adventure, about how connections can help save the world!',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 7, day: 29}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/672/898/e58ea9f8e63d3478562da363e0cd5ef5_original.jpg?ixlib=rb-4.0.2&w=680&fit=max&v=1622115740&auto=format&frame=1&q=92&s=c4857308ba4ff3ac1798f4608a99a300'],
  overallBack: '9000',
  currentBack: '5511'
})
CREATE (journey:Project {
  id:          '12',
  name:        'Journey to the Middle Kingdom Issue #1',
  description: '3 American teenagers are thrown into a fantasy world of Chinese folklore, and must use 3 magic brushes to save the past!',
  createdAt:   date(),
  deadline:    date({year: 2022, month: 3, day: 16}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/365/175/3e4846b0ef92744a4ea592ff0408bf70_original.JPG?ixlib=rb-4.0.2&w=680&fit=max&v=1619999088&auto=format&frame=1&q=92&s=b6cde8b95a2c81605cdaf8e2ef72247d'],
  overallBack: '3300',
  currentBack: '2100'
})
CREATE (vampire:Project {
  id:          '13',
  name:        'Vampire Bloodlines Comic Project 3',
  description: 'Vampire Bloodlines Issue 3',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 10, day: 18}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/824/193/4870d198de61723830c8610daee624e2_original.jpg?ixlib=rb-4.0.2&crop=faces&w=1024&h=576&fit=crop&v=1623204438&auto=format&frame=1&q=92&s=1453e02cc8cf3d594c472df72092971a'],
  overallBack: '1200',
  currentBack: '9810'
})
CREATE (azio:Project {
  id:          '14',
  name:        'AZIO IZO | Vibrant & Intuitive Wireless Keyboard Set',
  description: 'Tri-Tonal Colors | Dual Control Knob | Wireless or Wired | For Mac & Windows | Gateron Mechanical Switches | + Matching Accessories',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 12, day: 28}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/809/007/c2205dc2ae75f5ac00fe2cd2581d502a_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1623120202&auto=format&frame=1&lossless=true&s=228bd89143eedfd07249ac74e59f15d8'],
  overallBack: '10000',
  currentBack: '3210'
})
CREATE (watch:Project {
  id:          '15',
  name:        'NIXOID NEXT / nixie watch 2021',
  description: 'We want to show a new collection of absolutely unique metal and plastic watches based on nixie tubes.',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 9, day: 6}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/691/202/923d7cbb176dda227ab66b0d20fec766_original.JPG?ixlib=rb-4.0.2&w=680&fit=max&v=1622233520&auto=format&frame=1&q=92&s=7d605078846ce625d05c0faf3cbe1694'],
  overallBack: '12000',
  currentBack: '7123'
})
CREATE (vulcan:Project {
  id:          '16',
  name:        'VULCAN',
  description: 'High-quality 3D printing resin with pre-supported models in every bag!',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 8, day: 8}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/821/505/4a42b42239d8d738e057db1c3da12402_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1623185003&auto=format&frame=1&lossless=true&s=be1e59685d124be4a168d3fedeef83c1'],
  overallBack: '25000',
  currentBack: '14513'
})
CREATE (space:Project {
  id:          '17',
  name:        'The Space Safe - The first real smart safe',
  description: 'The most technologically advanced safe created; WiFi, App, Cameras, LCD display, Guest Access, & more. oh & it doesnt look like a safe',
  createdAt:   date(),
  deadline:    date({year: 2021, month: 12, day: 26}),
  imageUrls:   [
                 'https://ksr-ugc.imgix.net/assets/033/865/034/0e453e474497da6e697d8c938431fb07_original.png?ixlib=rb-4.0.2&w=680&fit=max&v=1623501861&auto=format&frame=1&lossless=true&s=a110f4deaa00744bfbd024e7631cf31a'],
  overallBack: '23000',
  currentBack: '17324'
})

CREATE (denis:User {
  id:        '1',
  username:  'denis',
  password:  '123456',
  fullName:  'Denis Borschevsky',
  createdAt: date(),
  birthday:  date({year: 2000, month: 2, day: 16}),
  avatar:    'https://64.media.tumblr.com/7ce8fc9c1d8abe766a09ddb4e98ea34f/tumblr_n74ywu6OTF1stbd2po1_500.gifv',
  about:     'I have a knack for creative thinking and overcoming hurdles, thats why Im part of Dreamer. I believe that collaboration between inventive people and hard-working workers can change the world.

'
})
CREATE (ivan:User {
  id:        '2',
  username:  'ivan',
  password:  '123456',
  fullName:  'Ivan Bayev',
  createdAt: date(),
  birthday:  date({year: 1985, month: 1, day: 9}),
  avatar:    'https://1.bp.blogspot.com/-u_8nm_azZK8/YJ-1yL3XyaI/AAAAAAAABZM/ufEs-Wovd1oCBaxtiM0l74_ipl2x72bKACLcBGAsYHQ/w680/FB_IMG_16210792508008945.jpg',
  about:     'I’ve been a bow ties and ties hardcore fan for years to come. This are amazing accessories, which help to outline the most charismatic, confident and intriguing aspects of me. So I am a customer myself who knows better than me what’s best for a client.'
})
CREATE (nat:User {
  id:        '3',
  username:  'nat',
  password:  '123456',
  fullName:  'Natali Frazentor',
  createdAt: date(),
  birthday:  date({year: 2002, month: 9, day: 23}),
  avatar:    'https://img.wattpad.com/aabb8a49a1f700be4457ecc04973e254289de2e8/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f4f7a5345555749536e58745532673d3d2d3938353832333935322e313634613365303636396561353561383733353531313032303236302e676966',
  about:     'I am a girl of eighteen. When I look at myself in the mirror I see a blond girl with short straight hair, dark eyes and a slender figure. As to my appearance I`m rather tall and slim. I have never thought I`m a beauty, I wish I were more beautiful. I think that I`m even tempered, rather reserved, calm and modest. But sometimes I can lose my temper and become either angry or sad. I like staying alone and sometimes I retreat into my shell. But at the same time I like my friends, I like to laugh and joke. I have got a sense of humour. It means I understand humour and appreciate it. There are many things in our life I like and some I dislike. I like when everything is OK. Being happy is one way of being wise. I like to study because knowledge is useful sometimes. I`m fond of reading as it gives not only knowledge, but also wonderful moments of joy and pleasure. I am neither short nor tall, so I like to wear high-heeled shoes, trousers or jeans.'
})

CREATE (p_1:Payment {
  id:        '1',
  amount:    '543.32',
  createdAt: date()
})
CREATE (p_2:Payment {
  id:        '2',
  amount:    '434.32',
  createdAt: date()
})

CREATE (faq_4:Faq {
  id:       '1',
  question: 'Reward says "Steam key," how do I choose a console?',
  answer:   'We can not edit rewards after they have been purchased but the stretch goal for consoles was reached so rest assured that everyone will be able to choose the console of their choice after the campaign ends. We will send a survey out.'
})
CREATE (faq_5:Faq {
  id:       '2',
  question: 'If I buy Alpha/Beta access do I still get a copy of the full game?',
  answer:   'All game access levels come with the previous access levels. If you back the alpha tier you will receive pre-alpha access, alpha access, beta access, and full launch access. Beta comes with beta and full-launch access'
})
CREATE (faq_6:Faq {
  id:       '3',
  question: 'Will there be multiplayer?',
  answer:   'We are not planning on adding multiplayer at this time but it is always a possibility down the road. Right now we are developing the best single-player experience we can and putting all our resources toward making that experience amazing.'
})

CREATE (faq_7:Faq {
  id:       '4',
  question: 'What platforms is Wanderlost coming to?',
  answer:   'Wanderlost will be released simultaneously on Windows and Nintendo Switch! We will also release on Xbox and Playstation after launch.'
})

CREATE (comment_1:Comment {
  id:        '1',
  createdAt: localdatetime(),
  message:   'I second the idea of a romance option. It seems like the game would be rather lonely without a human companion. I would also like to request character customization, even if it is just limited to male/female presenting characters. Having a character that is similar to me at all makes the experience much better'
})
CREATE (comment_2:Comment {
  id:        '2',
  createdAt: localdatetime(),
  message:   'So I am really excited for this game, however I wanted to ask before I made an add-on purchase. I got the tracker tier, and I know we can only pick either the gold tools or weapons. There are add-ons for both sets. Is it possible to select say the gold tools on my tier and then add-on the weapons? Thank you!'
})
CREATE (comment_3:Comment {
  id:        '3',
  createdAt: localdatetime(),
  message:   'If I add on say the golden god tools, and a second copy in the manager, do both copies get the golden god, I understand it is the same level of backing, but just wondering how it works for the add-ons. Would that have to be it is own separate pledge? Also how about the Arctic Fox as an add on?'
})

CREATE (design:Category {
  id:   '1',
  name: 'Design'
})
CREATE (games:Category {
  id:   '2',
  name: 'Games'
})
CREATE (technology:Category {
  id:   '3',
  name: 'Technology'
})
CREATE (comics:Category {
  id:   '4',
  name: 'Comics'
})
CREATE (fashion:Category {
  id:   '5',
  name: 'Fashion'
})
CREATE (music:Category {
  id:   '6',
  name: 'Music'
})
CREATE (apps:Category {
  id:   '7',
  name: 'Apps'
})

CREATE (back_option_1:BackOption {
  id:      '1',
  pledge:  20,
  rewards: ['🏅 Backer Title', '💿 (1) Digital Game Copy on Steam', '🖼️ Digital Wallpapers', '✍️ Name in the Credits',
             '🎵 Original Soundtrack']
})
CREATE (back_option_2:BackOption {
  id:      '2',
  pledge:  40,
  rewards: ['🪓 (1) Beta Access Key on Steam', '🏅 Backer Title', '🖼️ Digital Wallpapers', '✍️ Name in the Credits',
             '👑 Early Supporter Title', '🎒 Exclusive Backpack', '🎵 Original Soundtrack']
})
CREATE (back_option_3:BackOption {
  id:      '3',
  pledge:  100,
  rewards: ['🪑 Exclusive Furniture', '🦊 Arctic Fox (Rare Animal Exclusive)',
             '🥇 Golden Weapons (3) OR Sparkling Tools (2)', '⚒️ (1) Alpha Access Key on Steam',
             '🌱 Pre-Alpha Access After Campaign Ends', '🏅 Backer Title', '🖼️ Digital Wallpapers',
             '✍️ Name in the Credits', '👑 Early Supporter Title', '🎒 Exclusive Backpack', '📗 Digital Bushcraft Book',
             '🎵 Original Soundtrack']
})

CREATE
  (denis)-[:HAS]->(admin),
  (nat)-[:HAS]->(user),
  (ivan)-[:HAS]->(user),

  (denis)-[:OWNS]->(oven_steel),
  (ivan)-[:OWNS]->(pico_max),
  (nat)-[:OWNS]->(dedfish),
  (denis)-[:OWNS]->(hannibal),
  (ivan)-[:OWNS]->(cubes),
  (nat)-[:OWNS]->(wanderlost),
  (denis)-[:OWNS]->(heroes),
  (ivan)-[:OWNS]->(orbidice),
  (nat)-[:OWNS]->(mountain),
  (denis)-[:OWNS]->(sagas),
  (ivan)-[:OWNS]->(wayfinders),
  (nat)-[:OWNS]->(journey),
  (denis)-[:OWNS]->(vampire),
  (ivan)-[:OWNS]->(azio),
  (nat)-[:OWNS]->(watch),
  (denis)-[:OWNS]->(vulcan),
  (ivan)-[:OWNS]->(space),

  (oven_steel)-[:RELATED_TO]->(design),
  (pico_max)-[:RELATED_TO]->(design),
  (dedfish)-[:RELATED_TO]->(design),
  (hannibal)-[:RELATED_TO]->(design),
  (cubes)-[:RELATED_TO]->(design),
  (wanderlost)-[:RELATED_TO]->(games),
  (heroes)-[:RELATED_TO]->(games),
  (orbidice)-[:RELATED_TO]->(games),
  (mountain)-[:RELATED_TO]->(games),
  (sagas)-[:RELATED_TO]->(technology),
  (wayfinders)-[:RELATED_TO]->(technology),
  (journey)-[:RELATED_TO]->(technology),
  (vampire)-[:RELATED_TO]->(technology),
  (azio)-[:RELATED_TO]->(comics),
  (watch)-[:RELATED_TO]->(comics),
  (vulcan)-[:RELATED_TO]->(comics),
  (space)-[:RELATED_TO]->(comics),

  (oven_steel)-[:RELATED_TO]->(kickstarter),
  (pico_max)-[:RELATED_TO]->(kickstarter),
  (dedfish)-[:RELATED_TO]->(kickstarter),
  (hannibal)-[:RELATED_TO]->(kickstarter),
  (cubes)-[:RELATED_TO]->(kickstarter),
  (wanderlost)-[:RELATED_TO]->(kickstarter),
  (heroes)-[:RELATED_TO]->(kickstarter),
  (orbidice)-[:RELATED_TO]->(kickstarter),
  (mountain)-[:RELATED_TO]->(kickstarter),
  (sagas)-[:RELATED_TO]->(kickstarter),
  (wayfinders)-[:RELATED_TO]->(kickstarter),
  (journey)-[:RELATED_TO]->(kickstarter),
  (vampire)-[:RELATED_TO]->(kickstarter),
  (azio)-[:RELATED_TO]->(kickstarter),
  (watch)-[:RELATED_TO]->(kickstarter),
  (vulcan)-[:RELATED_TO]->(kickstarter),
  (space)-[:RELATED_TO]->(kickstarter),

  (wanderlost)-[:HAS]->(faq_4),
  (wanderlost)-[:HAS]->(faq_5),
  (wanderlost)-[:HAS]->(faq_6),
  (wanderlost)-[:HAS]->(faq_7),

  (wanderlost)-[:HAS]->(comment_1),
  (wanderlost)-[:HAS]->(comment_2),
  (wanderlost)-[:HAS]->(comment_3),

  (denis)-[:CREATES]->(comment_1),
  (nat)-[:CREATES]->(comment_2),
  (ivan)-[:CREATES]->(comment_3),

  (oven_steel)<-[:LIKES]-(denis),
  (oven_steel)<-[:LIKES]-(ivan),
  (pico_max)<-[:LIKES]-(nat),
  (pico_max)<-[:LIKES]-(denis),
  (hannibal)<-[:LIKES]-(nat),
  (wanderlost)<-[:LIKES]-(ivan),
  (wanderlost)<-[:LIKES]-(nat),
  (heroes)<-[:LIKES]-(denis),
  (sagas)<-[:LIKES]-(nat),
  (wayfinders)<-[:LIKES]-(nat),
  (wayfinders)<-[:LIKES]-(denis),
  (vampire)<-[:LIKES]-(nat),
  (azio)<-[:LIKES]-(nat),
  (vulcan)<-[:LIKES]-(nat),
  (vulcan)<-[:LIKES]-(denis),

  (wanderlost)-[:HAS]->(back_option_1),
  (wanderlost)-[:HAS]->(back_option_2),
  (wanderlost)-[:HAS]->(back_option_3)
