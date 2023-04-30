export type Feedback = {
  type: string;
  text: string;
  fingerprint: string;
  apiKey: string;
  device: string;
  page: string;
  idUser: string;
  user: {
    id: string;
  };
}
