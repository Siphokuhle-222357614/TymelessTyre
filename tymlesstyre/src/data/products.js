export const tyres = [
  { id: 1, name: "Michelin Pilot Sport 4", type: "Performance", size: "225/45R17", price: 220, image: "src/images/michelin_size_205_55r16.jpg" },
  { id: 2, name: "Goodyear Eagle F1",      type: "All-Season", size: "205/55R16", price: 160, image: "src/images/Goodyear Tyre size 225_45R17.jpg" },
  { id: 3, name: "Bridgestone Turanza",    type: "Touring",    size: "215/60R16", price: 190, image: "src/images/tyres/Bridgestone Turanza.jpg" },
  { id: 4, name: "Pirelli Cinturato P7",   type: "Eco",        size: "225/50R17", price: 180, image: "src/images/Pirelli tyre.png" },
  { id: 5, name: "Hankook Ventus",         type: "Budget",     size: "195/65R15", price: 110, image: "src/images/tyres/Hankook Ventus.png" },
  { id: 6, name: "Continental Premium Contact 6",    type: "Comfort",    size: "235/45R18", price: 240, image: "src/images/tyres/continental-premiumcontact-7-5.jpg.jpg" },
];

export const rims = [
  { id: 1, name: "Alloy Sport R17", type: "Alloy",   size: "17 inch", price: 260, image: "src/images/rims/Alloy R17.jpg" },
  { id: 2, name: "Alloy Black R18", type: "Alloy",   size: "18 inch", price: 320, image: "src/images/rims/Alloy rim.jpg" },
  { id: 3, name: "Chrome R19",      type: "Chrome",  size: "19 inch", price: 380, image: "src/images/rims/Chrome R19.jpg" },
  { id: 4, name: "Steel R16",       type: "Steel",   size: "16 inch", price: 160, image: "src/images/rims/Steel R16.jpg" },
  { id: 5, name: "Forged R20",      type: "Forged",  size: "20 inch", price: 520, image: "src/images/rims/Forged R20.png" },
  { id: 6, name: "Matte Grey R18",  type: "Alloy",   size: "18 inch", price: 300, image: "src/images/rims/Matte Grey R18.jpg" },
];

export function byKey(key){ return key === 'tyre' ? tyres : rims; }
