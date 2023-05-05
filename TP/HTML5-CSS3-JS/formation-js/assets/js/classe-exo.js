import Album from './album.class.js';

const albums = [
  new Album(1, "Shakira"),
  new Album(2, "Baby Shark")
];

for (let album of albums) {
  console.log(album.title);
}